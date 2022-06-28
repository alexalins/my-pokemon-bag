package com.alexa.mypokemonbag.mvp.presenter;

import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.model.domain.impl.PokemonServiceImpl;
import com.alexa.mypokemonbag.model.domain.service.PokemonService;
import com.alexa.mypokemonbag.mvp.contract.PokemonContract;

import java.util.List;

public class PokemonPresenter implements PokemonContract.Presenter {
    private PokemonContract.View view;
    private PokemonService pokemonService;

    public PokemonPresenter(PokemonContract.View view) {
        this.view = view;
        this.pokemonService = new PokemonServiceImpl();
        view.setPresenter(this);
    }

    @Override
    public void start() {
        view.bindViews();
    }

    @Override
    public List<Pokemon> getListPokemon() {
        List<Pokemon> list = pokemonService.getListPokemon();
        if(list.isEmpty()) {
            view.displayErrorMessage();
        }
        return list;
    }

    @Override
    public void nextPage() {
        view.pageDetailPokemon();
    }
}
