package br.edu.infnet.JacksonDaSilva.controller;

import br.edu.infnet.JacksonDaSilva.model.domain.Artista;
import br.edu.infnet.JacksonDaSilva.model.domain.Faixa;
import br.edu.infnet.JacksonDaSilva.model.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/starify/artistas")
public class ArtistaControler {
    @Autowired
    private ArtistaService artistaService;

    @GetMapping("/obter")
    public Collection<Artista> obterLista() {
        return artistaService.obterLista();
    }

    @GetMapping("/obter/{id}")
    public Artista obter(@PathVariable String id) {
        return artistaService.obter(id);
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Artista artista) {
        artistaService.incluir(artista);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable String id) {
        artistaService.excluir(id);
    }
}
