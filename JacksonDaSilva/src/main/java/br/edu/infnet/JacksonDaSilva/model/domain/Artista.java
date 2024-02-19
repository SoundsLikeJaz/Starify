package br.edu.infnet.JacksonDaSilva.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Artista {
    private String nome;
    private final List<Album> albuns = new ArrayList<>();
    protected final List<Faixa> faixas = new ArrayList<>();

    public Artista() {
        setNome("Anônimo");
    }

    public Artista(String nome) {
        setNome(nome);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if(!nome.isEmpty()) this.nome = nome;
        else throw new IllegalArgumentException("Erro: O nome do artista não pode estar em branco.");
    }

    public Album[] getAlbuns() {
        Album[] lista = new Album[albuns.size()];
        int index = 0;

        for(Album album : albuns) {
            lista[index] = album;
            index++;
        }

        return lista;
    }

    public String getStringAlbuns() {
        int index = 0;
        StringBuilder todasFaixas = new StringBuilder();
        while (index < albuns.size()) {
            todasFaixas.append(albuns.get(index).toString());
            index++;
        }
        return todasFaixas.toString();
    }

    public void addAlbum(Album album) {
        albuns.add(album);
        addFaixas(album.getFaixas());
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
        return String.format("Nome do artista: %s, \nAlbuns: %s\n", getNome(),
                albuns.isEmpty() ? "Sem álbuns lançados." : getStringAlbuns());
    }
}