package br.edu.infnet.JacksonDaSilva.model.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import static br.edu.infnet.JacksonDaSilva.model.domain.metodosGlobais.duracaoFormatada;

public class Album {
    private String artista;
    private String titulo;
    private int anoLancamento;
    private final List<Faixa> faixas = new ArrayList<>();
    private String genero;
    private Duration duracao;

    public Album() {
        setArtista("Desconhecido");
        setTitulo("Não informado");
        setGenero("Alternativo");
        setAnoLancamento(LocalDate.now().getYear());
    }

    public Album(String artista, String titulo, String genero, int anoLancamento) {
        setArtista(artista);
        setTitulo(titulo);
        setGenero(genero);
        setAnoLancamento(anoLancamento);
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) throws IllegalArgumentException {
        if(!artista.isEmpty()) this.artista = artista;
        else throw new IllegalArgumentException("Erro: O nome do artista não pode estar em branco.");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws IllegalArgumentException {
        if(!titulo.isEmpty()) this.titulo = titulo;
        else throw new IllegalArgumentException("Erro: Título não pode estar em branco.");
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) throws IllegalArgumentException {
        if(anoLancamento <= LocalDate.now().getYear() && anoLancamento > 0) this.anoLancamento = anoLancamento;
        else throw new IllegalArgumentException("Erro: Ano inválido.");
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) throws IllegalArgumentException {
        if(!genero.isEmpty()) this.genero = genero;
        else throw new IllegalArgumentException("Erro: O gênero não pode estar em branco.");
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
                Artista: %s, Título: %s, Ano de Lançamento: %d, Gênero: %s, Número de faixas: %d%s
                Faixas: %s
                """, getArtista(), getTitulo(), getAnoLancamento(), getGenero(), faixas.size(),
                getDuracao() == null ? "" : ", Duração: " + duracaoFormatada(duracao),
                faixas.isEmpty() ? "Álbum vazio." : getStringFaixas());
    }
}