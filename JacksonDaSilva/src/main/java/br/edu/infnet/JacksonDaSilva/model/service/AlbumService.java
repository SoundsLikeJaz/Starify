package br.edu.infnet.JacksonDaSilva.model.service;

import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AlbumService {

	private static Map<String, Album> albuns = new HashMap<String, Album>();
	
	public void incluir(Album album) {
		albuns.put(album.getTitulo(), album);
	}
	
	public void excluir(String titulo) {
		albuns.remove(titulo);
	}
	
	public Collection<Album> obterLista(){
		return albuns.values();
	}
	
	public Album obter(String titulo){
		return albuns.get(titulo);
	}
}