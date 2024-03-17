package br.edu.infnet.JacksonDaSilva.domain;

import br.edu.infnet.JacksonDaSilva.model.domain.Faixa;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FaixaTests {
    private Faixa faixa = new Faixa();

    @Test
    void faixaSemTitutlo() {
        String resultado = "falha";
        try {
            faixa.setTitulo("");
        } catch (IllegalArgumentException exception) {
            resultado = "sucesso";
        } finally {
            assertEquals("sucesso", resultado);
        }
    }

    @Test
    void faixaSemDuracao() {
        String resultado = "falha";
        try {
            faixa.setDuracao(Duration.ofSeconds(-10));
        } catch (IllegalArgumentException exception) {
            resultado = "sucesso";
        } finally {
            assertEquals("sucesso", resultado);
        }
    }

    @Test
    void durationMs() {
        faixa = new Faixa("ALL UP IN YOUR MIND", 169000, "auiym12");
        assertEquals(Duration.ofMinutes(2).plusSeconds(49), faixa.getDuracao());
    }

    @Test
    void tudoCertoVazio() {
        assertEquals("\nId: null, Título: Não informado, Duração: Indefinida", faixa.toString());
    }

    @Test
    void tudoCertoPreenchido() {
        faixa = new Faixa("Loner", Duration.ofMinutes(3).plusSeconds(32), "123l");
        assertEquals(Duration.ofMinutes(3).plusSeconds(32), faixa.getDuracao());
        assertEquals("\nId: 123l, Título: Loner, Duração: 03:32", faixa.toString());
    }
}