package com.alexa.mypokemonbag.mvp.presenter;

import com.alexa.mypokemonbag.model.Region;
import com.alexa.mypokemonbag.model.domain.impl.RegionServiceImpl;
import com.alexa.mypokemonbag.model.domain.service.RegionService;
import com.alexa.mypokemonbag.mvp.contract.RegionContract;

import java.util.List;

public class RegionPresenter implements RegionContract.Presenter{

    private RegionContract.View view;
    private RegionService regionService;

    public RegionPresenter(RegionContract.View view) {
        this.view = view;
        this.regionService = new RegionServiceImpl();
        view.setPresenter(this);
    }

    @Override
    public void start() {
        view.bindViews();
    }

    @Override
    public List<Region> getListPokemon() {
        List<Region> list = regionService.getListRegion();
        if(list.isEmpty()) {
            view.displayErrorMessage();
        }
        return list;
    }

    @Override
    public void nextPage() {
        view.pageListPokemon();
    }
}
