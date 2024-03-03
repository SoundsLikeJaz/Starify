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
    void tudoCertoVazio() {
        assertEquals("\nTítulo: Não informado, Duração: Indefinida", faixa.toString());
    }

    @Test
    void tudoCertoPreenchido() {
        faixa = new Faixa("Loner", Duration.ofMinutes(3).plusSeconds(32));
        assertEquals(Duration.ofMinutes(3).plusSeconds(32), faixa.getDuracao());
        assertEquals("\nTítulo: Loner, Duração: 03:32", faixa.toString());
    }
}