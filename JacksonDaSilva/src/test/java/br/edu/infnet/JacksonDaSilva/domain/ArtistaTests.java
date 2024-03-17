package br.edu.infnet.JacksonDaSilva.domain;

import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import br.edu.infnet.JacksonDaSilva.model.domain.Artista;
import br.edu.infnet.JacksonDaSilva.model.domain.Faixa;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ArtistaTests {
    Artista artista = new Artista();

    @Test
    void artistaSemNome() {
        String resultado = "falha";
        try {
            artista.setNome("");
        } catch (IllegalArgumentException exception) {
            resultado = "sucesso";
        } finally {
            assertEquals("sucesso", resultado);
        }
    }

    @Test
    void artistaSemAlbuns() {
        assertEquals(0, artista.getAlbuns().size());
        assertEquals("", artista.getStringAlbuns());
    }

    @Test
    void artistaSemFaixas() {
        assertEquals(0, artista.getFaixas().size());
        assertEquals("", artista.getStringFaixas());
    }

    @Test
    void artistaComAlbuns() {
        Album a1 = new Album("iii: Lost Chapter", new Artista("Pentakill"), "ptk5");
        Album a2 = new Album("ALL OUT", new Artista("K/DA"));

        artista.addAlbum(a1);
        artista.addAlbum(a2);

        assertEquals(2, artista.getAlbuns().size());
        assertEquals("""
                iii: Lost Chapter, ID: ptk5
                ALL OUT, ID: null
                """, artista.getStringAlbuns());
    }

    @Test
    void artistaComFaixas() {
        Album a2 = new Album("More", new Artista("K/DA"));
        Faixa theBaddest = new Faixa("THE BADDEST", Duration.ofMinutes(2).plusSeconds(42));
        Faixa more = new Faixa("MORE", Duration.ofMinutes(3).plusSeconds(37));
        Faixa villain = new Faixa("VILLAIN", Duration.ofMinutes(3).plusSeconds(19));

        a2.addFaixas(theBaddest);
        a2.addFaixas(more);
        a2.addFaixas(villain);

        artista.addAlbum(a2);

        Faixa lostChapter = new Faixa("Lost Chapter", Duration.ofMinutes(3).plusSeconds(49));
        Faixa predator = new Faixa("Predator", Duration.ofMinutes(4).plusSeconds(19));
        artista.addFaixa(lostChapter);
        artista.addFaixa(predator);

        assertEquals(5, artista.getFaixas().size());
        assertEquals("""

                Id: null, Título: THE BADDEST, Duração: 02:42
                Id: null, Título: MORE, Duração: 03:37
                Id: null, Título: VILLAIN, Duração: 03:19
                Id: null, Título: Lost Chapter, Duração: 03:49
                Id: null, Título: Predator, Duração: 04:19""", artista.getStringFaixas());
    }

    @Test
    void artistaVazio() {
        assertEquals("""
                \nNome do artista: Anônimo, Id: null\s
                Sem álbuns lançados.""", artista.toString());
    }

    @Test
    void artistaCompleto() {
        artista = new Artista("Riot Music");

        Album a1 = new Album("iii: Lost Chapter", new Artista("Pentakill"));
        Faixa lostChapter = new Faixa("Lost Chapter", Duration.ofMinutes(3).plusSeconds(49));
        Faixa predator = new Faixa("Predator", Duration.ofMinutes(4).plusSeconds(19));

        a1.addFaixas(lostChapter);
        a1.addFaixas(predator);

        Album a2 = new Album("More", new Artista("K/DA"));
        Faixa theBaddest = new Faixa("THE BADDEST", Duration.ofMinutes(2).plusSeconds(42));
        Faixa more = new Faixa("MORE", Duration.ofMinutes(3).plusSeconds(37));
        Faixa villain = new Faixa("VILLAIN", Duration.ofMinutes(3).plusSeconds(19));

        a2.addFaixas(theBaddest);
        a2.addFaixas(more);
        a2.addFaixas(villain);

        artista.addAlbum(a2);

        assertEquals("""
                
                Nome do artista: Riot Music, Id: null\s
                Lista de albuns:
                iii: Lost Chapter, ID: null
                More, ID: null
                """, artista.toString());
    }
}