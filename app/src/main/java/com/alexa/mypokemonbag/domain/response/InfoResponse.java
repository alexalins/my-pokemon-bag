package com.alexa.mypokemonbag.domain.response;

import com.google.gson.annotations.SerializedName;

public class InfoResponse {
    @SerializedName(value = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
