package com.alexa.mypokemonbag.domain.response;

import com.alexa.mypokemonbag.model.Region;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegionResponse {
    @SerializedName(value = "results")
    private List<Region> results;
    @SerializedName(value = "pokedexes")
    private List<RegionPokedexResponse> pokedexes;

    public List<Region> getResults() {
        return results;
    }

    public List<RegionPokedexResponse> getPokedexes() {
        return pokedexes;
    }
}
