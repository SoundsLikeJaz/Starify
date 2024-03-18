package br.edu.infnet.JacksonDaSilva.service;

import br.edu.infnet.JacksonDaSilva.model.domain.Faixa;
import br.edu.infnet.JacksonDaSilva.model.service.FaixaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

@SpringBootTest
public class FaixaServiceTests {

	@Autowired
	private FaixaService faixaService;

	private Faixa faixa;

    private final String ID = "rmn";

	@BeforeEach
	void setUp() {
		faixa = new Faixa("Remember my name", Duration.ZERO, ID);
	}

	@Test
	void inclusao() {

		faixaService.incluir(faixa);

		assertEquals(faixa, faixaService.obter(ID));
	}

	@Test
	void exclusao() {
		inclusao();

		faixaService.excluir(ID);

        try {
            assertNull(faixaService.obter(ID));
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
	}

	@Test
	void recuperacaoTotal() {
		inclusao();

		assertTrue(faixaService.obterLista().contains(faixa));
	}
}