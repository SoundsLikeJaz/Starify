package br.edu.infnet.JacksonDaSilva.model.domain;

import br.edu.infnet.JacksonDaSilva.model.service.AlbumService;
import br.edu.infnet.JacksonDaSilva.model.service.FaixaService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Artista {
    private String id;
    @JsonProperty("name")
    private String nome;
    private final List<Album> albuns = new ArrayList<>();
    protected final List<Faixa> faixas = new ArrayList<>();

    public Artista() {
        setNome("Anônimo");
    }

    public Artista(String nome) {
        setNome(nome);
    }

    public Artista(String nome, String id) {
        this(nome);
        setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if(!nome.isEmpty()) this.nome = nome;
        else throw new IllegalArgumentException("Erro: O nome do artista não pode estar em branco.");
    }

    public List<Album> getAlbuns() {
        return this.albuns;
    }

    public String getStringAlbuns() {
        int index = 0;
        StringBuilder todasFaixas = new StringBuilder();
        while (index < albuns.size()) {
            todasFaixas.append(albuns.get(index).getTitulo() + ", ID: " + albuns.get(index).getId() + "\n");
            index++;
        }
        return todasFaixas.toString();
    }

    public void addAlbum(Album album) {
        albuns.add(album);
        addFaixas(album.getFaixas());
    }

    public void addAlbumsExternos(List<Album> albuns, AlbumService albumService) {
        for(Album album : albuns) addAlbum(albumService.obter(album.getId()));
    }

    public List<Faixa> getFaixas() {
        return faixas;
    }

    public String getStringFaixas() {
        return metodosGlobais.getStringFaixas(faixas);
    }

    public void addFaixas(List<Faixa> faixas) {
        this.faixas.addAll(faixas);
    }

    public void addFaixa(Faixa faixa) {
        this.faixas.add(faixa);
    }

    @Override
    public String toString() {
        return String.format("\nNome do artista: %s, Id: %s %s", getNome(), getId(),
                albuns.isEmpty() ? "\nSem álbuns lançados." : "\nLista de albuns:\n" + getStringAlbuns());
    }
}