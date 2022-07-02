package com.alexa.mypokemonbag.mvp.contract;

import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.mvp.BaseContract;

public interface DetailBagContract {

    interface View extends BaseContract.BaseView<DetailBagContract.Presenter> {
        void displayErrorMessage();
        void pageAddPokemon();
        void pageDetailPokemon();
        void loadDataBag(Bag bag);
        void createDialogEdit();
        void createDialogDelete();
    }

    interface Presenter extends BaseContract.BasePresenter {
        void getBag(Bag bag);
        void savePokemon();
        void dialiogEdit();
        void dialiogDelete();
        void detailPokemon();
    }
}
