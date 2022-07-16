package com.alexa.mypokemonbag.mvp.contract;

import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.mvp.BaseContract;

public interface DetailPokemonContract {

    interface View extends BaseContract.BaseView<DetailPokemonContract.Presenter> {
        void displayErrorMessage();
        void displaySuccessSaveMessage();
        void displayErrorSaveMessage();
        void loadDataPokemon(Pokemon pokemon);
    }

    interface Presenter extends BaseContract.BasePresenter {
        Pokemon getDetailPokemon();
        void savePokemon();
        void getPokemon(Pokemon pokemon);
    }
}
