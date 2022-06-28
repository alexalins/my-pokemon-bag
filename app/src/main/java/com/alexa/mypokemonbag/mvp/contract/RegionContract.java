package com.alexa.mypokemonbag.mvp.contract;

import com.alexa.mypokemonbag.model.Region;
import com.alexa.mypokemonbag.mvp.BaseContract;

import java.util.List;

public interface RegionContract {
    interface View extends BaseContract.BaseView<RegionContract.Presenter> {
        void displayErrorMessage();
        void pageListPokemon();
    }

    interface Presenter extends BaseContract.BasePresenter {
        List<Region> getListPokemon();
        void nextPage();
    }
}
