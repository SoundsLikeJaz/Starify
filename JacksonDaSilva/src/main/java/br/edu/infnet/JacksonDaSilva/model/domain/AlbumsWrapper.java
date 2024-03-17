package br.edu.infnet.JacksonDaSilva.model.domain;

import java.util.ArrayList;
import java.util.List;

public class AlbumsWrapper {
    private List<Album> items = new ArrayList<>();

    public AlbumsWrapper() {

    }

    public AlbumsWrapper(List<Album> items) {
        setItems(items);
    }

    public List<Album> getItems() {
        return items;
    }

    public void setItems(List<Album> items) {
        this.items = items;
    }
}
