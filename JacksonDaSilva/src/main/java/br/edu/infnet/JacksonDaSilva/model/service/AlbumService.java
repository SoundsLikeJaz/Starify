package br.edu.infnet.JacksonDaSilva.model.service;

import br.edu.infnet.JacksonDaSilva.clients.AlbumClient;
import br.edu.infnet.JacksonDaSilva.clients.AuthSpotifyClient;
import br.edu.infnet.JacksonDaSilva.clients.LoginRequest;
import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AlbumService {

	@Autowired
	private AuthSpotifyClient authSpotifyClient;

	@Autowired
	private AlbumClient albumClient;

	LoginRequest loginRequest = new LoginRequest("client_credentials", "4036e01125a140219242b8e978c2b69b", "bcd8b4519848406e9575fb7d21892073");

	String token = authSpotifyClient.login(loginRequest).getAccessToken();

	//Suspeito que agr eu preciso do Response

	private static Map<String, Album> albuns = new HashMap<String, Album>();
	
	public void incluir(Album album) {
		albuns.put(album.getId(), album);
	}
	
	public void excluir(String id) {
		albuns.remove(id);
	}
	
	public Collection<Album> obterLista(){
		return albumClient.getReleases("Bearer " + token);
	}
	
	public Album obter(String id){
		return albumClient.obter("Bearer " + token, id);
	}
}