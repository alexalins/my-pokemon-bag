package com.alexa.mypokemonbag.util;

import com.alexa.mypokemonbag.model.Pokemon;
import com.google.gson.Gson;

public class PokemonUtil {

    public static String pokemonToJson(Pokemon pokemon) {
        if(pokemon != null) {
            Gson gson = new Gson();
            String myjson = gson.toJson(pokemon);

            return myjson;
        }
        return "";
    }

    public static Pokemon jsonToPokemon(String json) {
        Pokemon myPokemon = new Pokemon();
        if(json != null) {
            Gson gson = new Gson();
            myPokemon = gson.fromJson(json, Pokemon.class);

            return myPokemon;
        }
        return myPokemon;
    }
}
