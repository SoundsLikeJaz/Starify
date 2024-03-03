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
	
	private final String TITULO = "Remember my name";

	@BeforeEach
	void setUp() {
		faixa = new Faixa(TITULO, Duration.ZERO);
	}
	
	@Test
	void inclusao() {
		
		faixaService.incluir(faixa);
		
		assertEquals(faixa, faixaService.obter(TITULO));
	}
	
	@Test
	void exclusao() {
		inclusao();
		
		faixaService.excluir(TITULO);

        assertNull(faixaService.obter(TITULO));
	}
	
	@Test
	void recuperacaoTotal() {
		inclusao();
		
		assertTrue(faixaService.obterLista().contains(faixa));
	}
}
