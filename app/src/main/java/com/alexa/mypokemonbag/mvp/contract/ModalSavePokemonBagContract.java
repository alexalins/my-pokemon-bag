package com.alexa.mypokemonbag.mvp.contract;

import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.mvp.BaseContract;

import java.util.List;

public interface ModalSavePokemonBagContract {
    interface View extends BaseContract.BaseView<ModalSavePokemonBagContract.Presenter> {
        void displayErrorMessage();
        void displaySaveMessage();
    }

    interface Presenter extends BaseContract.BasePresenter {
        List<Bag> getListBag();
        void savePokemon();
    }
}
