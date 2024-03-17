package br.edu.infnet.JacksonDaSilva.service;

import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import br.edu.infnet.JacksonDaSilva.model.service.AlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AlbumServiceTests {

	@Autowired
	private AlbumService albumService;

	private Album album;

    private final String ID = "btcb";

	@BeforeEach
	void setUp() {
		album = new Album("Be the cowboy");
        album.setId(ID);
	}

	@Test
	void inclusao() {

		albumService.incluir(album);

		assertEquals(album, albumService.obter(ID));
	}

	@Test
	void exclusao() {
		inclusao();

		albumService.excluir(ID);

        try {
            assertNull(albumService.obter(ID));
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }

	}

	@Test
	void recuperacaoTotal() {
		inclusao();

		assertTrue(albumService.obterLista().contains(album));
	}
}
