package com.alexa.mypokemonbag.mvp.presenter;

import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.model.domain.response.PokedexResponse;
import com.alexa.mypokemonbag.model.domain.response.PokemonResponse;
import com.alexa.mypokemonbag.model.domain.response.RegionResponse;
import com.alexa.mypokemonbag.model.domain.service.PokemonService;
import com.alexa.mypokemonbag.model.domain.service.RegionService;
import com.alexa.mypokemonbag.mvp.contract.PokemonContract;
import com.alexa.mypokemonbag.util.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonPresenter implements PokemonContract.Presenter {
    private PokemonContract.View view;
    private PokemonService pokemonService;
    private List<Pokemon> listPokedex;

    public PokemonPresenter(PokemonContract.View view) {
        this.view = view;
        view.setPresenter(this);
        //
        //
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.pokemonService = retrofit.create(PokemonService.class);
    }

    @Override
    public void start() {
        view.bindViews();
    }

    @Override
    public void getListPokemon(String id) {
        Call<PokedexResponse> resquest = pokemonService.getPokedex(id);
        resquest.enqueue(new Callback<PokedexResponse>() {
            @Override
            public void onResponse(Call<PokedexResponse> call, Response<PokedexResponse> response) {
                PokedexResponse repository = response.body();
                List<PokemonResponse> list = repository.getPokemonList();
                listPokedex = new ArrayList<>();
                for (PokemonResponse pokemon: list){
                    Pokemon p = new Pokemon(pokemon.getId(), pokemon.getSpecie().getName(), pokemon.getSpecie().getUrl());
                    listPokedex.add(p);
                }
                view.loadDataPokemon(listPokedex);
            }

            @Override
            public void onFailure(Call<PokedexResponse> call, Throwable t) {
                view.displayErrorMessage();
            }
        });
    }

    @Override
    public void nextPage() {
        view.pageDetailPokemon();
    }
}
