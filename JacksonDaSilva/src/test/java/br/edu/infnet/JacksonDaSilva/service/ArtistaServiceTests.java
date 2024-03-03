package br.edu.infnet.JacksonDaSilva.service;

import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import br.edu.infnet.JacksonDaSilva.model.domain.Artista;
import br.edu.infnet.JacksonDaSilva.model.service.ArtistaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ArtistaServiceTests {

	@Autowired
	private ArtistaService artistaService;
	
	private Artista artista;
	
	private final String NOME = "Mitski";

	@BeforeEach
	void setUp() {
		artista = new Artista(NOME);
	}
	
	@Test
	void inclusao() {
		
		artistaService.incluir(artista);
		
		assertEquals(artista, artistaService.obter(NOME));
	}
	
	@Test
	void exclusao() {
		inclusao();
		
		artistaService.excluir(NOME);

        assertNull(artistaService.obter(NOME));
	}
	
	@Test
	void recuperacaoTotal() {
		inclusao();
		
		assertTrue(artistaService.obterLista().contains(artista));
	}
}
