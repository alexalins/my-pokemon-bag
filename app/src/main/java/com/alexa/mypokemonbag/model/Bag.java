package com.alexa.mypokemonbag.model;

import java.util.List;

public class Bag {

    private Long id;
    private String title;
    private String description;
    private List<Pokemon> pokemons;

    public Bag(){

    }

    public Bag(Long id, String title, String description, List<Pokemon> pokemons) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pokemons = pokemons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pokemons=" + pokemons +
                '}';
    }
}
