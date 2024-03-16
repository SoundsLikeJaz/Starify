package br.edu.infnet.JacksonDaSilva.clients;

import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import br.edu.infnet.JacksonDaSilva.model.domain.AlbumsWrapper;
import br.edu.infnet.JacksonDaSilva.model.domain.Artista;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(url = "https://api.spotify.com", name = "artistaClient")
public interface ArtistaClient {
    @GetMapping("/v1/artists/{id}")
    Artista obter(@RequestHeader("Authorization") String authorization, @PathVariable String id);

    @GetMapping("/v1/artists/{id}/albums")
    AlbumsWrapper obterAlbuns(@RequestHeader("Authorization") String authorization, @PathVariable String id);
}