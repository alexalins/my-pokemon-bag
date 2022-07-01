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

    public static String validateNumber(int id) {
        String number = String.valueOf(id);
        if(number.length() == 1) {
            return "00"+ number;
        }
        if(number.length() == 2) {
            return "0"+ number;
        }
        return number;
    }
}
