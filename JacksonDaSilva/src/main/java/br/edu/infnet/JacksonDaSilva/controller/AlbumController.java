package br.edu.infnet.JacksonDaSilva.controller;


import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import br.edu.infnet.JacksonDaSilva.model.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/starify/albuns")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/obter")
    public Collection<Album> obterLista() {
        return albumService.obterLista();
    }

    @GetMapping("/obter/{id}")
    public Album obter(@PathVariable String id) {
        return albumService.obter(id);
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Album album) {
        albumService.incluir(album);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable String id) {
        albumService.excluir(id);
    }
}