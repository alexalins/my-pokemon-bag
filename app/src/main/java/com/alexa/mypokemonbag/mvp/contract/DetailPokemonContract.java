package com.alexa.mypokemonbag.mvp.contract;

import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.mvp.BaseContract;

public interface DetailPokemonContract {

    interface View extends BaseContract.BaseView<DetailPokemonContract.Presenter> {
        void displayErrorMessage();
        void pageBags();
    }

    interface Presenter extends BaseContract.BasePresenter {
        Pokemon getDetailPokemon();
        void savePokemon();
    }
}
