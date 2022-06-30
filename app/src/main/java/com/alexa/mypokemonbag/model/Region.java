package com.alexa.mypokemonbag.model;

import com.google.gson.annotations.SerializedName;

public class Region {
    @SerializedName(value = "name")
    private String name;
    @SerializedName(value = "url")
    private String url;

    public Region() {
    }

    public Region(String name, String url) {
        this.name = name;
        this.url = url;
    }

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

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
