package com.alexa.mypokemonbag.model.domain.response;

import com.google.gson.annotations.SerializedName;

public class PokemonResponse {
    @SerializedName(value = "entry_number")
    private int id;
    @SerializedName(value = "pokemon_species")
    private SpecieResponse specie;

    public int getId() {
        return id;
    }

    public SpecieResponse getSpecie() {
        return specie;
    }

    @Override
    public String toString() {
        return "PokemonResponse{" +
                "id=" + id +
                ", specie=" + specie +
                '}';
    }
}
