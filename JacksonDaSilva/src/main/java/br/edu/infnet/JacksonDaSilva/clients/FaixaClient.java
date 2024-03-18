package br.edu.infnet.JacksonDaSilva.clients;

import br.edu.infnet.JacksonDaSilva.model.domain.Faixa;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://api.spotify.com", name = "faixaClient")
public interface FaixaClient {
    @GetMapping("/v1/tracks/{id}")
    Faixa obter(@RequestHeader("Authorization") String authorization, @PathVariable String id);
}