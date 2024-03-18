package br.edu.infnet.JacksonDaSilva.model.domain;

import java.util.ArrayList;
import java.util.List;

public class TracksWrapper {
    private List<Faixa> items = new ArrayList<>();

    public TracksWrapper() {

    }

    public TracksWrapper(List<Faixa> items) {
        setItems(items);
    }

    public List<Faixa> getItems() {
        return items;
    }

    public void setItems(List<Faixa> items) {
        this.items = items;
    }
}