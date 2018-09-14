package com.example.marksong.application.Network.Response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DogResponse implements Serializable{
    @SerializedName("url")
    String doggoUrl;

    public String getDoggoUrl() {
        return doggoUrl;
    }

    public void setDoggoUrl(String doggoUrl) {
        this.doggoUrl = doggoUrl;
    }
}
