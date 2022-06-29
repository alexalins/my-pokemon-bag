package com.alexa.mypokemonbag.mvp.contract;

import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.mvp.BaseContract;

import java.util.List;

public interface PokemonContract {
    interface View extends BaseContract.BaseView<PokemonContract.Presenter> {
        void displayErrorMessage();
        void pageDetailPokemon();
    }

    interface Presenter extends BaseContract.BasePresenter {
        List<Pokemon> getListPokemon();
        void nextPage();
    }
}