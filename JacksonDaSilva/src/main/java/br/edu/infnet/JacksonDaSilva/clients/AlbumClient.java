package br.edu.infnet.JacksonDaSilva.clients;

import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://api.spotify.com", name = "albumClient")
public interface AlbumClient {
    @GetMapping("/v1/albums/{id}")
    Album obter(@RequestHeader("Authorization") String authorization, @PathVariable String id);
}