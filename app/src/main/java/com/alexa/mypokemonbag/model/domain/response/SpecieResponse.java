package com.alexa.mypokemonbag.model.domain.response;

import com.google.gson.annotations.SerializedName;

public class SpecieResponse {
    @SerializedName(value = "name")
    private String name;
    @SerializedName(value = "url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
