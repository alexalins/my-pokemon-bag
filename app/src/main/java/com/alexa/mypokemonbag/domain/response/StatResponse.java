package com.alexa.mypokemonbag.domain.response;

import com.google.gson.annotations.SerializedName;

public class StatResponse {

    @SerializedName(value = "base_stat")
    private int base;

    @SerializedName(value = "stat")
    private InfoResponse stat;

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public InfoResponse getStat() {
        return stat;
    }

    public void setStat(InfoResponse stat) {
        this.stat = stat;
    }
}
