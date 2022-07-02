package com.alexa.mypokemonbag.util;

import com.alexa.mypokemonbag.model.Bag;
import com.google.gson.Gson;

public class BagUtil {

    public static String bagToJson(Bag bag) {
        if(bag != null) {
            Gson gson = new Gson();
            String myjson = gson.toJson(bag);

            return myjson;
        }
        return "";
    }

    public static Bag jsonToBag(String json) {
        Bag myBag = new Bag();
        if(json != null) {
            Gson gson = new Gson();
            myBag = gson.fromJson(json, Bag.class);

            return myBag;
        }
        return myBag;
    }
}
