package com.alexa.mypokemonbag.presenter;

import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.view.HomeContract;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        view.bindViews();
    }

    @Override
    public List<Bag> getListsBag() {
        return null;
    }
}
