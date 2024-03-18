package br.edu.infnet.JacksonDaSilva;

import br.edu.infnet.JacksonDaSilva.model.domain.Artista;
import br.edu.infnet.JacksonDaSilva.model.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ArtistaLoader implements ApplicationRunner {
    @Autowired
    private ArtistaService artistaService;

    public void run(ApplicationArguments args) throws Exception {
        Artista mitski = artistaService.obter("2uYWxilOVlUdk4oV9DvwqK");
        System.out.println(mitski);
        artistaService.incluir(mitski);

        Artista kda = artistaService.obter("4gOc8TsQed9eqnqJct2c5v");
        System.out.println(kda);
        artistaService.incluir(kda);

        Artista pentakill = artistaService.obter("2qcGTB5s2t9o2w9SrI719s");
        System.out.println(pentakill);
        artistaService.incluir(pentakill);

        Artista beyonce = artistaService.obter("6vWDO969PvNqNYHIOW5v0m");
        System.out.println(beyonce);
        artistaService.incluir(beyonce);
    }
}