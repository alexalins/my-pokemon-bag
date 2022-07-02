package com.alexa.mypokemonbag.domain.service;

import com.alexa.mypokemonbag.domain.response.RegionResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RegionService {
    @GET(value = "region")
    Call<RegionResponse> getListRegion();

    @GET(value = "region/{id}")
    Call<RegionResponse> getRegion(@Path("id") String id);
}
