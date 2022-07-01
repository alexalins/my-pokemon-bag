package com.alexa.mypokemonbag.model.domain.service;

import com.alexa.mypokemonbag.model.domain.response.PokedexResponse;
import com.alexa.mypokemonbag.model.domain.response.RegionPokedexResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {
    @GET(value = "pokedex/{id}")
    Call<PokedexResponse> getPokedex(@Path("id") String id);
}
