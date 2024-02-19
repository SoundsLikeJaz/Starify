package br.edu.infnet.JacksonDaSilva.model.domain;

import java.time.Duration;
import java.util.List;

public class metodosGlobais {
    public static String duracaoFormatada(Duration duracao) {
        String tempo;

        long horas = duracao.toHours();
        long minutos = duracao.toMinutes() % 60;
        long segundos = duracao.getSeconds() % 60;

        if(horas != 0) tempo = String.format("%02d:%02d:%02d", horas, minutos, segundos);
        else if(minutos >= 0 && segundos > 0) tempo = String.format("%02d:%02d", minutos, segundos);
        else tempo = "Indefinida";

        return tempo;
    }

    public static String getStringFaixas(List<Faixa> faixas) {
        int index = 0;
        StringBuilder todasFaixas = new StringBuilder();
        while (index < faixas.size()) {
            todasFaixas.append(faixas.get(index).toString());
            index++;
        }
        return todasFaixas.toString();
    }
}