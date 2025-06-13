package com.projeto.services;

import com.projeto.dtos.CepDTO;
import com.projeto.services.exceptions.WebClientExceptions;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CepService {

    private WebClient webClient;

    public CepService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://viacep.com.br/ws").build();
    }

    public Mono<CepDTO> buscarCep(String cep) {

        return webClient
                .get() // requisição HTTP
                .uri("/{cep}/json", cep) // endpoint de destino
                .retrieve() // executa a requisição e extrai a resposta
                .onStatus(
                        status -> status.is4xxClientError() || status.is5xxServerError(),
                        response -> response
                                .bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(new WebClientExceptions("Erro" )))
                )
                .bodyToMono(CepDTO.class); // converte para Mono<CepDTO>
    }
}
