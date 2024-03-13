package br.edu.infnet.JacksonDaSilva.model.domain;

import feign.form.FormProperty;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import static br.edu.infnet.JacksonDaSilva.model.domain.metodosGlobais.duracaoFormatada;

public class Album {
    private String id;
    @FormProperty("name")
    private String titulo;
    @FormProperty("artists")
    private String artista;
    private int anoLancamento;
    private final List<Faixa> faixas = new ArrayList<>();
    @FormProperty("genres")
    private String genero;
    private Duration duracao;

    public Album() {
        setTitulo("Não informado");
        setArtista("Desconhecido");
        setGenero("Alternativo");
        setAnoLancamento(LocalDate.now().getYear());
    }

    public Album(String titulo) {
        this();
        this.setTitulo(titulo);
    }

    public Album(String titulo, String artista) {
        this(titulo);
        this.setArtista(artista);
    }

    public Album(String titulo, String artista, String genero) {
        this(titulo, artista);
        this.setGenero(genero);
    }

    public Album(String titulo, String artista, String genero, int anoLancamento) {
        this(titulo, artista, genero);
        this.setAnoLancamento(anoLancamento);
    }

    public Album(String titulo, String artista, String genero, int anoLancamento, String id) {
        this(titulo, artista, genero, anoLancamento);
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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) throws IllegalArgumentException {
        if(!artista.isEmpty()) this.artista = artista;
        else throw new IllegalArgumentException("Erro: O nome do artista não pode estar em branco.");
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
                %s Artista: %s, Título: %s, Ano de Lançamento: %d, Gênero: %s, Número de faixas: %d%s
                Faixas: %s
                """, getId() == null ? "" : ("ID: " + getId() + ","), getArtista(), getTitulo(), getAnoLancamento(),
                getGenero(),
                faixas.size(),
                getDuracao() == null ? "" : ", Duração: " + duracaoFormatada(duracao),
                faixas.isEmpty() ? "Álbum vazio." : getStringFaixas());
    }
}