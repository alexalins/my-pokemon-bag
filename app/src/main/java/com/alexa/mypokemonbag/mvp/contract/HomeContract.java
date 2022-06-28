package com.alexa.mypokemonbag.mvp.contract;

import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.mvp.BaseContract;

import java.util.List;

public interface HomeContract {

    interface View extends BaseContract.BaseView<Presenter> {
        void displayErrorMessage();
        void pageRegion();
    }

    interface Presenter extends BaseContract.BasePresenter {
        List<Bag> getListsBag();
        void nextPage();
    }
}
