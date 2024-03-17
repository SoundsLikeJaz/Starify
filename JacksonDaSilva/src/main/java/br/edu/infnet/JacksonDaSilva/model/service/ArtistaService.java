package br.edu.infnet.JacksonDaSilva.model.service;

import br.edu.infnet.JacksonDaSilva.clients.ArtistaClient;
import br.edu.infnet.JacksonDaSilva.clients.AuthSpotifyClient;
import br.edu.infnet.JacksonDaSilva.clients.LoginRequest;
import br.edu.infnet.JacksonDaSilva.model.domain.AlbumsWrapper;
import br.edu.infnet.JacksonDaSilva.model.domain.Artista;
import br.edu.infnet.JacksonDaSilva.model.domain.Faixa;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ArtistaService {

	@Autowired
	private AuthSpotifyClient authSpotifyClient;

	@Autowired
	private ArtistaClient artistaClient;

	@Autowired
	AlbumService albumService;

	private String token;

	@PostConstruct
	private void init() {
		LoginRequest loginRequest = new LoginRequest("client_credentials", "4036e01125a140219242b8e978c2b69b", "bcd8b4519848406e9575fb7d21892073");
		token = authSpotifyClient.login(loginRequest).getAccessToken();
	}

	private static Map<String, Artista> artistas = new HashMap<String, Artista>();
	
	public void incluir(Artista artista) {
		artistas.put(artista.getId(), artista);
	}
	
	public void excluir(String id) {
		artistas.remove(id);
	}
	
	public Collection<Artista> obterLista(){
		return artistas.values();
	}
	
	public Artista obter(String id){
		if(artistas.get(id) != null) return artistas.get(id);
		else return obterExterno(token, id);
	}

	private Artista obterExterno(String authorization, String id) {
		Artista artista = artistaClient.obter("Bearer " + authorization, id);
		AlbumsWrapper albumsWrapper = artistaClient.obterAlbuns("Bearer " + authorization, id);
		artista.addAlbumsExternos(albumsWrapper.getItems(), albumService);
		return artista;
	}
}