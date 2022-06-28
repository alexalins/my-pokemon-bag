package com.alexa.mypokemonbag.model.domain.impl;

import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.model.domain.service.BagService;

import java.util.ArrayList;
import java.util.List;

public class BagServiceImpl implements BagService {
    @Override
    public List<Bag> getListBag() {
        return listMock();
    }

    private List<Bag> listMock() {
        //mock
        Bag bag = new Bag(1l, "Pokemon Shield", "meus pokemons", null);
        Bag bag2 = new Bag(2l, "Pokemon Arceus", "meus pokemons shinny", null);
        Bag bag3 = new Bag(3l, "Pokemon que faltam", "pokemon q quero", null);

        List<Bag> list = new ArrayList<>();
        list.add(bag);
        list.add(bag2);
        list.add(bag3);
        return list;
    }
}