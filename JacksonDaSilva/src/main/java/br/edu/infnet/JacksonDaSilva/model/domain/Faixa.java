package br.edu.infnet.JacksonDaSilva.model.domain;

import java.time.Duration;

import static br.edu.infnet.JacksonDaSilva.model.domain.metodosGlobais.duracaoFormatada;

public class Faixa {
    private String titulo;
    private Duration duracao;

    public Faixa() {
        setTitulo("Não informado");
        setDuracao(Duration.ZERO);
    }

    public Faixa(String titulo, Duration duracao) {
        setTitulo(titulo);
        setDuracao(duracao);
    }

    public Faixa(String titulo, int duracao) {
        setTitulo(titulo);
        setDuracao(duracao);
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
        return String.format("\nTítulo: %s, Duração: %s", getTitulo(), duracaoFormatada(duracao));
    }
}