package br.edu.infnet.JacksonDaSilva.domain;

import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import br.edu.infnet.JacksonDaSilva.model.domain.Artista;
import br.edu.infnet.JacksonDaSilva.model.domain.Faixa;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AlbumTests {
    private Album album = new Album();

    @Test
    void albumSemArtista() {
        String resultado = "falha";
        try {
            album.setArtista(null);
        } catch (IllegalArgumentException exception) {
            resultado = "sucesso";
        } finally {
            assertEquals("sucesso", resultado);
        }
    }

    @Test
    void albumSemTitulo() {
        String resultado = "falha";
        try {
            album.setTitulo("");
        } catch (IllegalArgumentException exception) {
            resultado = "sucesso";
        } finally {
            assertEquals("sucesso", resultado);
        }
    }

    @Test
    void albumSemFaixas() {
        assertEquals("", album.getStringFaixas());
        assertEquals(0, album.getFaixas().size());
        assertNull(album.getDuracao());
    }

    @Test
    void albumVazio() {
        assertEquals("""
                
                Id: null, Artista: Anônimo, Título: Não informado, Número de faixas: 0
                Faixas: Álbum vazio.
                """, album.toString());
    }

    @Test
    void albumCompleto() {
        album = new Album("iii: Lost Chapter", new Artista("Pentakill"), "3ls");
        Faixa lostChapter = new Faixa("Lost Chapter", Duration.ofMinutes(3).plusSeconds(49));
        Faixa predator = new Faixa("Predator", Duration.ofMinutes(4).plusSeconds(19));
        Faixa edgeOfNight = new Faixa("Edge of Night", Duration.ofMinutes(4).plusSeconds(48));
        Faixa gatheringStorm = new Faixa("Gathering Storm", Duration.ofMinutes(4).plusSeconds(37));
        Faixa conqueror = new Faixa("Conqueror", Duration.ofMinutes(4).plusSeconds(10));

        album.addFaixas(lostChapter);
        album.addFaixas(predator);
        album.addFaixas(edgeOfNight);
        album.addFaixas(gatheringStorm);
        album.addFaixas(conqueror);

        assertEquals("""
                
                Id: 3ls, Artista: Pentakill, Título: iii: Lost Chapter, Número de faixas: 5, Duração: 21:43
                Faixas:\s
                Id: null, Título: Lost Chapter, Duração: 03:49
                Id: null, Título: Predator, Duração: 04:19
                Id: null, Título: Edge of Night, Duração: 04:48
                Id: null, Título: Gathering Storm, Duração: 04:37
                Id: null, Título: Conqueror, Duração: 04:10
                """, album.toString());
    }
}