package com.alexa.mypokemonbag.mvp.presenter;

import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.model.domain.service.BagService;
import com.alexa.mypokemonbag.model.domain.impl.BagServiceImpl;
import com.alexa.mypokemonbag.mvp.contract.HomeContract;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private BagService service;

    public HomePresenter(HomeContract.View view) {
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
    public void nextPage() {
        view.pageRegion();
    }

    @Override
    public void dialiogSave() {
        view.createDialog();
    }
}
