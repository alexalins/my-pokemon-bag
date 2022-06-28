package com.alexa.mypokemonbag.model.domain.impl;

import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.model.domain.service.PokemonService;

import java.util.ArrayList;
import java.util.List;

public class PokemonServiceImpl implements PokemonService {
    @Override
    public List<Pokemon> getListPokemon() {
        return listMock();
    }

    private List<Pokemon> listMock() {
        //mock
        Pokemon pokemon = new Pokemon(1l, "Charmander", "");
        Pokemon pokemon2 = new Pokemon(1l, "Chameleon", "");
        Pokemon pokemon3 = new Pokemon(1l, "Charizard", "");

        List<Pokemon> list = new ArrayList<>();
        list.add(pokemon);
        list.add(pokemon2);
        list.add(pokemon3);
        return list;
    }
}
