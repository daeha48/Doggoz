package com.example.marksong.application.Network;

import com.example.marksong.application.Network.Response.DogResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceMethod {

    @GET("/woof.json")
    Call<DogResponse> getRandoDoggo();
}
