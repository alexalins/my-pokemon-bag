package com.alexa.mypokemonbag.model.domain.response;

import com.alexa.mypokemonbag.model.Region;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegionResponse {
    public int count;
    public Object next;
    public Object previous;
    @SerializedName("results")
    public List<Region> results;

    public List<Region> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "RegionRepository{" +
                "count=" + count +
                ", next=" + next +
                ", previous=" + previous +
                ", results=" + results +
                '}';
    }
}
