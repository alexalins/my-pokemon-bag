package com.alexa.mypokemonbag.domain.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailPokemonResponse {

    @SerializedName(value = "stats")
    private List<StatResponse> status;

    @SerializedName(value = "types")
    private List<TypeResponse> types;

    @SerializedName(value = "weight")
    private int weight;

    @SerializedName(value = "height")
    private int height;

    public List<StatResponse> getStatus() {
        return status;
    }

    public void setStatus(List<StatResponse> status) {
        this.status = status;
    }

    public List<TypeResponse> getTypes() {
        return types;
    }

    public void setTypes(List<TypeResponse> types) {
        this.types = types;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
