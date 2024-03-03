package br.edu.infnet.JacksonDaSilva.model.service;

import br.edu.infnet.JacksonDaSilva.model.domain.Artista;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ArtistaService {

	private static Map<String, Artista> artistas = new HashMap<String, Artista>();
	
	public void incluir(Artista artista) {
		artistas.put(artista.getNome(), artista);
	}
	
	public void excluir(String nome) {
		artistas.remove(nome);
	}
	
	public Collection<Artista> obterLista(){
		return artistas.values();
	}
	
	public Artista obter(String nome){
		return artistas.get(nome);
	}
}