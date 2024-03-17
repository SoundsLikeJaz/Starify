package br.edu.infnet.JacksonDaSilva.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

import static br.edu.infnet.JacksonDaSilva.model.domain.metodosGlobais.duracaoFormatada;

public class Album {
    private String id;
    @JsonProperty("name")
    private String titulo;
    @JsonProperty("artists")
    private Artista artista;
    @JsonProperty("tracks")
    private final List<Faixa> faixas = new ArrayList<>();
    private Duration duracao;

    public Album() {
        setTitulo("Não informado");
        setArtista(new Artista());
    }

    public Album(String titulo) {
        this();
        this.setTitulo(titulo);
    }

    public Album(String titulo, Artista artista) {
        this(titulo);
        this.setArtista(artista);
    }

    public Album(String titulo, Artista artista, String id) {
        this(titulo, artista);
        this.setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws IllegalArgumentException {
        if(!titulo.isEmpty()) this.titulo = titulo;
        else throw new IllegalArgumentException("Erro: Título não pode estar em branco.");
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) throws IllegalArgumentException {
        if(artista != null) this.artista = artista;
        else throw new IllegalArgumentException("Erro: O nome do artista não pode estar em branco.");
    }

    @JsonSetter("artists")
    public void setFirstArtist(List<Artista> artists) {
        if (artists != null && !artists.isEmpty()) {
            this.artista = artists.get(0);
        }
    }

    public List<Faixa> getFaixas() {
        return faixas;
    }

    public String getStringFaixas() {
        return metodosGlobais.getStringFaixas(faixas);
    }

    public void addFaixas(Faixa faixa) {
        faixas.add(faixa);
        setDuracao();
    }

    @JsonSetter("tracks")
    public void addFaixas(TracksWrapper faixas) {
        this.faixas.addAll(faixas.getItems());
        setDuracao();
    }

    public Duration getDuracao() {
        return duracao;
    }

    private void setDuracao() {
        Duration minutos = Duration.ZERO;
        for(Faixa faixa : faixas) minutos = minutos.plus(faixa.getDuracao());
        duracao = minutos;
    }

    @Override
    public String toString() {
        return String.format("""
                \nId: %s, Artista: %s, Título: %s, Número de faixas: %d%s
                Faixas: %s
                """, getId(), getArtista().getNome(), getTitulo(), faixas.size(),
                getDuracao() == null ? "" : ", Duração: " + duracaoFormatada(duracao),
                faixas.isEmpty() ? "Álbum vazio." : getStringFaixas());
    }
}