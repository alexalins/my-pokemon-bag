package com.alexa.mypokemonbag.util;

import android.content.Context;
import android.widget.Toast;

public class Utils {

    public static void toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static String getBaseUrl() {
        return "https://pokeapi.co/api/v2/";
    }
    public static String getUrl() {
        return "URL";
    }
    public static String getBag() {
        return "BAG";
    }
    public static String getPokemon() {
        return "POKEMON";
    }
    public static String getEdit() {
        return "EDIT";
    }

    public static String validateNumber(String id) {
        String number = String.valueOf(id);
        if(number.length() == 1) {
            return "00"+ number;
        }
        if(number.length() == 2) {
            return "0"+ number;
        }
        return number;
    }

    public static String getIdPokemon(String url) {
        String number = url.substring(42);
        number = number.replaceAll("[^0-9]", "");
        return number;
    }

    public static String getUrlImage(String url) {
        String id = Utils.validateNumber(Utils.getIdPokemon(url));
        String urlImage = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"+ id +".png";
        return urlImage;
    }
}
