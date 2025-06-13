package com.projeto.services;

import com.projeto.dtos.CepDTO;
import com.projeto.repositories.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
                .get()
                .uri("/{cep}/json", cep)
                .retrieve()
                .bodyToMono(CepDTO.class);
    }
}
