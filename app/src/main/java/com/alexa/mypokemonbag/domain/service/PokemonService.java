package com.alexa.mypokemonbag.domain.service;

import com.alexa.mypokemonbag.domain.response.PokedexResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {
    @GET(value = "pokedex/{id}")
    Call<PokedexResponse> getPokedex(@Path("id") String id);
}
