package com.alexa.mypokemonbag.mvp.presenter;

import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.mvp.contract.DetailBagContract;

public class DetailBagPresenter implements DetailBagContract.Presenter {

    private DetailBagContract.View view;

    public DetailBagPresenter(DetailBagContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        view.bindViews();
    }

    @Override
    public void getBag(Bag bag) {
        view.loadDataBag(bag);
    }

    @Override
    public void savePokemon() {
        view.pageAddPokemon();
    }

    @Override
    public void detailPokemon() {
        view.pageDetailPokemon();
    }

    @Override
    public void dialiogEdit() {
        view.createDialogEdit();
    }

    @Override
    public void dialiogDelete() {
        view.createDialogDelete();
    }
}
