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
}
