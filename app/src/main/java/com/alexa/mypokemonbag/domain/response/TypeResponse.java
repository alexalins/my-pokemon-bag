package com.alexa.mypokemonbag.domain.response;

import com.google.gson.annotations.SerializedName;

public class TypeResponse {
    @SerializedName(value = "type")
    private InfoResponse type;

    public InfoResponse getType() {
        return type;
    }

    public void setType(InfoResponse type) {
        this.type = type;
    }
}
