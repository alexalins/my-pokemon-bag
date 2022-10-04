package com.alexa.mypokemonbag.domain.response;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokedexResponse {
    @SerializedName(value = "pokemon_entries")
    private List<PokemonResponse> pokemonList;

    public List<PokemonResponse> getPokemonList() {
        return pokemonList;
    }

    @Override
    public String toString() {
        return "PokedexResponse{" +
                "pokemonList=" + pokemonList +
                '}';
    }
}
