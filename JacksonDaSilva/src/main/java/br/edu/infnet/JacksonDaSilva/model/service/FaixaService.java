package br.edu.infnet.JacksonDaSilva.model.service;

import br.edu.infnet.JacksonDaSilva.model.domain.Faixa;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FaixaService {

	private static Map<String, Faixa> faixas = new HashMap<String, Faixa>();
	
	public void incluir(Faixa faixa) {
		faixas.put(faixa.getTitulo(), faixa);
	}
	
	public void excluir(String titulo) {
		faixas.remove(titulo);
	}
	
	public Collection<Faixa> obterLista(){
		return faixas.values();
	}
	
	public Faixa obter(String titulo){
		return faixas.get(titulo);
	}
}