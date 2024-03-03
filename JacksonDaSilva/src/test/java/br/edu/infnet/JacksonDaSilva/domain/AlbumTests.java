package br.edu.infnet.JacksonDaSilva.domain;

import br.edu.infnet.JacksonDaSilva.model.domain.Album;
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
            album.setArtista("");
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
    void albumSemGenero() {
        String resultado = "falha";
        try {
            album.setGenero("");
        } catch (IllegalArgumentException exception) {
            resultado = "sucesso";
        } finally {
            assertEquals("sucesso", resultado);
        }
    }

    @Test
    void albumAnoLancamentoZero() {
        try {
            album.setAnoLancamento(0);
            fail();
        } catch (IllegalArgumentException exception) {
            assertTrue(true);
        }
    }

    @Test
    void albumAnoLancamentoNegativo() {
        try {
            album.setAnoLancamento(-1);
            fail();
        } catch (IllegalArgumentException exception) {
            assertTrue(true);
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
                Artista: Desconhecido, Título: Não informado, Ano de Lançamento: 2024, Gênero: Alternativo, Número de faixas: 0
                Faixas: Álbum vazio.
                """, album.toString());
    }

    @Test
    void albumCompleto() {
        album = new Album("Pentakill", "iii: Lost Chapter", "Rock", 2021);
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
                Artista: Pentakill, Título: iii: Lost Chapter, Ano de Lançamento: 2021, Gênero: Rock, Número de faixas: 5, Duração: 21:43
                Faixas:\s
                Título: Lost Chapter, Duração: 03:49
                Título: Predator, Duração: 04:19
                Título: Edge of Night, Duração: 04:48
                Título: Gathering Storm, Duração: 04:37
                Título: Conqueror, Duração: 04:10
                """, album.toString());
    }
}