package com.alexa.mypokemonbag.mvp.presenter;

import com.alexa.mypokemonbag.domain.response.DetailPokemonResponse;
import com.alexa.mypokemonbag.domain.response.PokedexResponse;
import com.alexa.mypokemonbag.domain.response.PokemonResponse;
import com.alexa.mypokemonbag.domain.service.PokemonService;
import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.mvp.contract.DetailPokemonContract;
import com.alexa.mypokemonbag.util.PokemonUtil;
import com.alexa.mypokemonbag.util.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailPokemonPresenter implements DetailPokemonContract.Presenter {

    private DetailPokemonContract.View view;
    private PokemonService pokemonService;
    private Pokemon pokemon;

    public DetailPokemonPresenter(DetailPokemonContract.View view) {
        this.view = view;
        view.setPresenter(this);
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
    public Pokemon getDetailPokemon() {
        return null;
    }

    @Override
    public void savePokemon() {
        view.displaySuccessSaveMessage();
    }

    @Override
    public void getPokemon(Pokemon mypokemon) {
        Call<DetailPokemonResponse> resquest = pokemonService.getPokemon(mypokemon.getId());
        //
        resquest.enqueue(new Callback<DetailPokemonResponse>() {
            @Override
            public void onResponse(Call<DetailPokemonResponse> call, Response<DetailPokemonResponse> response) {
                DetailPokemonResponse pokemonResponse = response.body();
                pokemon = PokemonUtil.responseToPokemon(pokemonResponse, mypokemon);
                view.loadDataPokemon(pokemon);
            }

            @Override
            public void onFailure(Call<DetailPokemonResponse> call, Throwable t) {
                view.displayErrorMessage();
            }
        });
    }
}
