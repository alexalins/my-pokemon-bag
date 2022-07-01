package com.alexa.mypokemonbag.mvp.contract;

import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.mvp.BaseContract;

import java.util.List;

public interface PokemonContract {
    interface View extends BaseContract.BaseView<PokemonContract.Presenter> {
        void displayErrorMessage();
        void pageDetailPokemon();
        void loadDataPokemon(List<Pokemon> list);
    }

    interface Presenter extends BaseContract.BasePresenter {
        void getListPokemon(String id);
        void nextPage();
    }
}
