package com.pseudoi.app.webservice;

import com.pseudoi.app.model.BeerCraft;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/beercraft")
    Call<List<BeerCraft>> doGetBeerCraft();
}