package br.edu.infnet.JacksonDaSilva.controller;


import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import br.edu.infnet.JacksonDaSilva.model.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/starify/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/listar")
    public Collection<Album> oterLista() {
        return albumService.obterLista();
    }
}
