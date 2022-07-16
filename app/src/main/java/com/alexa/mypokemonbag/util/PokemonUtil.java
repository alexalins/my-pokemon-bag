package com.alexa.mypokemonbag.util;

import com.alexa.mypokemonbag.domain.response.DetailPokemonResponse;
import com.alexa.mypokemonbag.domain.response.PokedexResponse;
import com.alexa.mypokemonbag.domain.response.PokemonResponse;
import com.alexa.mypokemonbag.domain.response.StatResponse;
import com.alexa.mypokemonbag.domain.response.TypeResponse;
import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.model.Stat;
import com.alexa.mypokemonbag.model.Type;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

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

    public static Pokemon responseToPokemon(DetailPokemonResponse response, Pokemon pokemon) {

        if(response != null) {
            pokemon.setHeight(response.getHeight());
            pokemon.setWeight(response.getWeight());
            pokemon.setTypes(responseToType(response.getTypes()));
            pokemon.setStats(responseToStat(response.getStatus()));

            return pokemon;
        }
        return pokemon;
    }

    private static List<Type> responseToType(List<TypeResponse> typeResponse) {
        List<Type> newTypes = new ArrayList<>();
        //
        if(typeResponse != null) {
            for (TypeResponse tr : typeResponse) {
                Type type = new Type(tr.getType().getName());
                newTypes.add(type);
            }
            return newTypes;
        }
        //
        return newTypes;
    }

    private static List<Stat> responseToStat(List<StatResponse> statResponse) {
        List<Stat> newStat = new ArrayList<>();
        //
        if(statResponse != null) {
            for (StatResponse sr : statResponse) {
                Stat stat = new Stat(sr.getStat().getName(), sr.getBase());
                newStat.add(stat);
            }
            return newStat;
        }
        //
        return newStat;
    }
}
