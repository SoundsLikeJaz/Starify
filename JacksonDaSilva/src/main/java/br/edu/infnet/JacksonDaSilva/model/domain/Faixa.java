package br.edu.infnet.JacksonDaSilva.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Duration;

import static br.edu.infnet.JacksonDaSilva.model.domain.metodosGlobais.duracaoFormatada;

public class Faixa {
    private String id;
    @JsonProperty("name")
    private String titulo;
    @JsonProperty("duration_ms")
    private Duration duracao;

    public Faixa() {
        setTitulo("Não informado");
        setDuracao(Duration.ZERO);
    }

    public Faixa(String titulo, Duration duracao) {
        setTitulo(titulo);
        setDuracao(duracao);
    }

    public Faixa(String titulo, Duration duracao, String id) {
        this(titulo, duracao);
        setId(id);
    }

    public Faixa(String titulo, int duracao) {
        setTitulo(titulo);
        setDuracao(duracao);
    }

    public Faixa(String titulo, int duracao, String id) {
        this(titulo, duracao);
        setId(id);
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
        else throw new IllegalArgumentException("Erro: O nome do artista não pode estar em branco.");
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) throws IllegalArgumentException {
        if(duracao < 0) throw new IllegalArgumentException("Erro: A duração não pode ser negativa.");
        else this.duracao = Duration.ofMillis(duracao);
    }

    public void setDuracao(Duration duracao) throws IllegalArgumentException {
        if(duracao.isNegative()) throw new IllegalArgumentException("Erro: A duração não pode ser negativa.");
        else this.duracao = duracao;
    }

    @Override
    public String toString() {
        return String.format("\nId: %s, Título: %s, Duração: %s", getId(), getTitulo(), duracaoFormatada(duracao));
    }
}