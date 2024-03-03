package br.edu.infnet.JacksonDaSilva;

import br.edu.infnet.JacksonDaSilva.model.domain.Album;
import br.edu.infnet.JacksonDaSilva.model.domain.Artista;
import br.edu.infnet.JacksonDaSilva.model.domain.Faixa;

import java.time.Duration;

public class GravadoraTestes {
    public static void main(String[] args) {
        Artista a1 = new Artista();
        System.out.println(a1);

        Artista Elberth = new Artista("Elberth");
        Album Java = new Album();

        Java.setArtista("Elberth");
        Java.setTitulo("Java");
        Java.setAnoLancamento(2024);
        Java.setGenero("Rock");
        System.out.println(Java);

        Album JavaScript = new Album("JavaScript", "Elberth", "Jazz", 2023);
        System.out.println(JavaScript);

        Faixa odeioMeusAlunos = new Faixa("Odeio Meus Alunos", Duration.ofMinutes(3).plusSeconds(35));

        Faixa vouTeReprovar = new Faixa();
        System.out.println(vouTeReprovar);
        vouTeReprovar.setTitulo("Vou Te Reprovar");
        vouTeReprovar.setDuracao(Duration.ofMinutes(5).plusSeconds(23));

        JavaScript.addFaixas(odeioMeusAlunos);
        JavaScript.addFaixas(vouTeReprovar);

        System.out.println(JavaScript);

        Faixa perfeccionista = new Faixa();
        Elberth.addFaixa(perfeccionista);

        Elberth.addAlbum(Java);
        Elberth.addAlbum(JavaScript);

        System.out.println(Elberth);
        System.out.println(Elberth.getFaixas().size() == 2);
        System.out.println(Elberth.getStringFaixas());

        System.out.println(Elberth.getAlbuns().length == 3);
        System.out.println(Elberth.getStringAlbuns());

        try {
            Album excecao = new Album();
            excecao.setArtista("");
        } catch (IllegalArgumentException exception) {
            System.out.println("Exceção barrada: " + exception);
        }

        try {
            Album excecao = new Album();
            excecao.setTitulo("");
        } catch (IllegalArgumentException exception) {
            System.out.println("Exceção barrada: " + exception);
        }

        try {
            Album excecao = new Album();
            excecao.setGenero("");
        } catch (IllegalArgumentException exception) {
            System.out.println("Exceção barrada: " + exception);
        }

        try {
            Album excecao = new Album();
            excecao.setAnoLancamento(0);
        } catch (IllegalArgumentException exception) {
            System.out.println("Exceção barrada: " + exception);
        }

        try {
            Faixa excecao = new Faixa("Teste", Duration.ZERO);
            excecao.setTitulo("");
        } catch (IllegalArgumentException exception) {
            System.out.println("Exceção barrada: " + exception);
        }

        try {
            Artista excecao = new Artista();
            excecao.setNome("");
        } catch (IllegalArgumentException exception) {
            System.out.println("Exceção barrada: " + exception);
        }
    }
}