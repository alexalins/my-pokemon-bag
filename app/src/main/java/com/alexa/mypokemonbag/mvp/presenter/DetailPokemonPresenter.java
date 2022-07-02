package com.alexa.mypokemonbag.mvp.presenter;

import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.mvp.contract.DetailPokemonContract;

public class DetailPokemonPresenter implements DetailPokemonContract.Presenter {

    private DetailPokemonContract.View view;

    public DetailPokemonPresenter(DetailPokemonContract.View view) {
        this.view = view;
        view.setPresenter(this);
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
}
