package br.edu.infnet.JacksonDaSilva.model.service;

import br.edu.infnet.JacksonDaSilva.clients.AuthSpotifyClient;
import br.edu.infnet.JacksonDaSilva.clients.FaixaClient;
import br.edu.infnet.JacksonDaSilva.clients.LoginRequest;
import br.edu.infnet.JacksonDaSilva.model.domain.Faixa;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FaixaService {

	@Autowired
	private AuthSpotifyClient authSpotifyClient;

	@Autowired
	private FaixaClient faixaClient;

	private String token;

	@PostConstruct
	private void init() {
		LoginRequest loginRequest = new LoginRequest("client_credentials", "4036e01125a140219242b8e978c2b69b", "bcd8b4519848406e9575fb7d21892073");
		token = authSpotifyClient.login(loginRequest).getAccessToken();
	}

	private static Map<String, Faixa> faixas = new HashMap<String, Faixa>();
	
	public void incluir(Faixa faixa) {
		faixas.put(faixa.getId(), faixa);
	}
	
	public void excluir(String id) {
		faixas.remove(id);
	}
	
	public Collection<Faixa> obterLista(){
		return faixas.values();
	}

	public Faixa obter(String id){
		if(faixas.get(id) != null) return faixas.get(id);
		else return obterExterno(token, id);
	}

	private Faixa obterExterno(String authorization, String id) {
		return faixaClient.obter("Bearer " + authorization, id);
	}
}