package br.edu.infnet.JacksonDaSilva;

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
        assertEquals(0, artista.getAlbuns().length);
        assertEquals("", artista.getStringAlbuns());
    }

    @Test
    void artistaSemFaixas() {
        assertEquals(0, artista.getFaixas().size());
        assertEquals("", artista.getStringFaixas());
    }

    @Test
    void artistaComAlbuns() {
        Album a1 = new Album("Pentakill", "iii: Lost Chapter", "Rock", 2021);
        Album a2 = new Album("KD/A", "ALL OUT", "Pop", 2020);

        artista.addAlbum(a1);
        artista.addAlbum(a2);

        assertEquals(2, artista.getAlbuns().length);
        assertEquals("""
                Artista: Pentakill, Título: iii: Lost Chapter, Ano de Lançamento: 2021, Gênero: Rock, Número de faixas: 0
                Faixas: Álbum vazio.
                Artista: KD/A, Título: ALL OUT, Ano de Lançamento: 2020, Gênero: Pop, Número de faixas: 0
                Faixas: Álbum vazio.
                """, artista.getStringAlbuns());
    }

    @Test
    void artistaComFaixas() {
        Album a2 = new Album("KD/A", "More", "Pop", 2020);
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

                Título: THE BADDEST, Duração: 02:42
                Título: MORE, Duração: 03:37
                Título: VILLAIN, Duração: 03:19
                Título: Lost Chapter, Duração: 03:49
                Título: Predator, Duração: 04:19""", artista.getStringFaixas());
    }

    @Test
    void artistaVazio() {
        assertEquals("""
                Nome do artista: Anônimo,\s
                Albuns: Sem álbuns lançados.
                """, artista.toString());
    }

    @Test
    void artistaCompleto() {
        artista = new Artista("Riot Music");

        Album a1 = new Album("Pentakill", "iii: Lost Chapter", "Rock", 2021);
        Faixa lostChapter = new Faixa("Lost Chapter", Duration.ofMinutes(3).plusSeconds(49));
        Faixa predator = new Faixa("Predator", Duration.ofMinutes(4).plusSeconds(19));

        a1.addFaixas(lostChapter);
        a1.addFaixas(predator);

        artista.addAlbum(a1);

        Album a2 = new Album("KD/A", "More", "Pop", 2020);
        Faixa theBaddest = new Faixa("THE BADDEST", Duration.ofMinutes(2).plusSeconds(42));
        Faixa more = new Faixa("MORE", Duration.ofMinutes(3).plusSeconds(37));
        Faixa villain = new Faixa("VILLAIN", Duration.ofMinutes(3).plusSeconds(19));

        a2.addFaixas(theBaddest);
        a2.addFaixas(more);
        a2.addFaixas(villain);

        artista.addAlbum(a2);

        assertEquals("""
                Nome do artista: Riot Music,\s
                Albuns: Artista: Pentakill, Título: iii: Lost Chapter, Ano de Lançamento: 2021, Gênero: Rock, Número de faixas: 2, Duração: 08:08
                Faixas:\s
                Título: Lost Chapter, Duração: 03:49
                Título: Predator, Duração: 04:19
                Artista: KD/A, Título: More, Ano de Lançamento: 2020, Gênero: Pop, Número de faixas: 3, Duração: 09:38
                Faixas:\s
                Título: THE BADDEST, Duração: 02:42
                Título: MORE, Duração: 03:37
                Título: VILLAIN, Duração: 03:19

                """, artista.toString());
    }
}