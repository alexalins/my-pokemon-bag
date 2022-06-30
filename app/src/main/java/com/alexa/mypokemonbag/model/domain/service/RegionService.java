package com.alexa.mypokemonbag.model.domain.service;

import com.alexa.mypokemonbag.model.domain.response.RegionResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RegionService {
    @GET(value = "region")
    Call<RegionResponse> getListRegion();
}
