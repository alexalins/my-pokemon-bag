package com.alexa.mypokemonbag.mvp.presenter;

import com.alexa.mypokemonbag.model.Region;
import com.alexa.mypokemonbag.domain.response.RegionPokedexResponse;
import com.alexa.mypokemonbag.domain.response.RegionResponse;
import com.alexa.mypokemonbag.domain.service.RegionService;
import com.alexa.mypokemonbag.mvp.contract.RegionContract;
import com.alexa.mypokemonbag.util.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegionPresenter implements RegionContract.Presenter {

    private RegionContract.View view;
    private RegionService regionService;
    private List<Region> listRegion;
    private List<RegionPokedexResponse> listPokedex;

    public RegionPresenter(RegionContract.View view) {
        this.view = view;
        view.setPresenter(this);
        //
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.regionService = retrofit.create(RegionService.class);
    }

    @Override
    public void start() {
        view.bindViews();
    }

    @Override
    public void getListRegion() {
        Call<RegionResponse> resquest = regionService.getListRegion();
        resquest.enqueue(new Callback<RegionResponse>() {
            @Override
            public void onResponse(Call<RegionResponse> call, Response<RegionResponse> response) {
                RegionResponse repository = response.body();
                listRegion = repository.getResults();
                view.loadListPokemon(listRegion);
            }

            @Override
            public void onFailure(Call<RegionResponse> call, Throwable t) {
                view.displayErrorMessage();
            }
        });
    }

    @Override
    public void nextPage(String url) {
        String id = url.substring(33);
        Call<RegionResponse> resquest = regionService.getRegion(id);
        resquest.enqueue(new Callback<RegionResponse>() {
            @Override
            public void onResponse(Call<RegionResponse> call, Response<RegionResponse> response) {
                try {
                    RegionResponse repository = response.body();
                    listPokedex = repository.getPokedexes();
                    //pegando a primeira pq só precisa dela
                    view.pageListPokemon(listPokedex.get(0).getUrl());
                } catch (Exception e) {
                    view.displayErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<RegionResponse> call, Throwable t) {
                view.displayErrorMessage();
            }
        });
    }
}
