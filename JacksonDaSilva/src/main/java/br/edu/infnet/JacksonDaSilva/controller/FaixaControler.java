package br.edu.infnet.JacksonDaSilva.controller;

import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import br.edu.infnet.JacksonDaSilva.model.domain.Faixa;
import br.edu.infnet.JacksonDaSilva.model.service.FaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/starify/faixas")
public class FaixaControler {
    @Autowired
    private FaixaService faixaService;

    @GetMapping("/obter")
    public Collection<Faixa> obterLista() {
        return faixaService.obterLista();
    }

    @GetMapping("/obter/{id}")
    public Faixa obter(@PathVariable String id) {
        return faixaService.obter(id);
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Faixa faixa) {
        faixaService.incluir(faixa);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable String id) {
        faixaService.excluir(id);
    }
}
