package br.edu.infnet.JacksonDaSilva;

import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import br.edu.infnet.JacksonDaSilva.model.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AlbumLoader implements ApplicationRunner {
    @Autowired
    private AlbumService albumService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Album lush = albumService.obter("22MICAVuz34zzqm4Se5Lga");
        System.out.println(lush);
        albumService.incluir(lush);

        Album allOut = albumService.obter("26IdRjba8f8DNa7c0FwfQb");
        System.out.println(allOut);
        albumService.incluir(allOut);

        Album smiteAndIgnite = albumService.obter("15uKqLeki8fZuLdR44Qtz8");
        System.out.println(smiteAndIgnite);
        albumService.incluir(smiteAndIgnite);

        Album renaissance = albumService.obter("6FJxoadUE4JNVwWHghBwnb");
        System.out.println(renaissance);
        albumService.incluir(renaissance);
    }
}