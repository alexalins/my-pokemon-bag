package com.alexa.mypokemonbag.model;

public class Region {
    private String name;
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
