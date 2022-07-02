package com.alexa.mypokemonbag.domain.impl;

import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.domain.service.BagService;
import com.alexa.mypokemonbag.model.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BagServiceImpl implements BagService {
    @Override
    public List<Bag> getListBag() {
        return listMock();
    }

    private List<Bag> listMock() {
        //mock
        Pokemon bulbasaur = new Pokemon(1, "bulbasaur", "https://pokeapi.co/api/v2/pokemon-species/1/");
        Pokemon charmander = new Pokemon(4, "charmander", "https://pokeapi.co/api/v2/pokemon-species/4/");
        Pokemon squirtle = new Pokemon(7, "squirtle", "https://pokeapi.co/api/v2/pokemon-species/7/");
        List<Pokemon> pokemons = Arrays.asList(bulbasaur, charmander, squirtle);
        Bag bag = new Bag(1l, "Pokemon Shield", "meus pokemons", pokemons);
        Bag bag2 = new Bag(2l, "Pokemon Arceus", "meus pokemons shinny", pokemons);
        Bag bag3 = new Bag(3l, "Pokemon que faltam", "pokemon q quero", pokemons);

        List<Bag> list = Arrays.asList(bag, bag2, bag3);
        return list;
    }
}