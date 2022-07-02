package com.alexa.mypokemonbag.mvp.presenter;

import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.domain.impl.BagServiceImpl;
import com.alexa.mypokemonbag.domain.service.BagService;
import com.alexa.mypokemonbag.mvp.contract.ModalSavePokemonBagContract;

import java.util.List;

public class ModalSavePokemonBagPresenter implements ModalSavePokemonBagContract.Presenter{

    private ModalSavePokemonBagContract.View view;
    private BagService service;

    public ModalSavePokemonBagPresenter(ModalSavePokemonBagContract.View view) {
        this.view = view;
        this.service = new BagServiceImpl();
        view.setPresenter(this);
    }

    @Override
    public void start() {
        view.bindViews();
    }

    @Override
    public List<Bag> getListBag() {
        List<Bag> list = service.getListBag();
        if(list.isEmpty()) {
            view.displayErrorMessage();
        }
        return list;
    }

    @Override
    public void savePokemon() {
        view.displaySaveMessage();
    }
}
