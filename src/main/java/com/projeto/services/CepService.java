package com.projeto.services;

import com.projeto.dtos.CepDTO;
import com.projeto.services.exceptions.CepNotFoundException;
import com.projeto.services.exceptions.WebClientExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class CepService {

    private WebClient webClient;

    public CepService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://viacep.com.br/ws").build();
    }

    public Mono<CepDTO> buscarCep(String cep) {

        if (!cep.matches("\\d{8}")) {
            return Mono.error(new WebClientExceptions("O CEP deve conter 8 dígitos."));
        }

        return webClient
                .get()
                .uri("/{cep}/json", cep)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response ->
                        Mono.error(new WebClientExceptions("Erro de cliente ao buscar o CEP."))
                )
                .onStatus(HttpStatusCode::is5xxServerError, response ->
                        Mono.error(new WebClientExceptions("Erro do servidor externo ao buscar o CEP."))
                )
                .bodyToMono(CepDTO.class)
                .flatMap(dto -> {
                    if (dto.getCep() == null || dto.getLocalidade() == null) {
                        return Mono.error(new CepNotFoundException("CEP não encontrado."));
                    }
                    return Mono.just(dto);
                });

    }
}
