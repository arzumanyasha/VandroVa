package com.example.user.vandrova.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceAPIFactory {
    public static class Url{
        public static final String BASE_URL = "https://maps.googleapis.com";
        public static final String API_KEY = "AIzaSyBBIbdXmPUNQobPh7nCRSmAVLr4UheQ1po";
    }

    public static PlaceAPI getPlaceService(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PlaceAPI.class);
    }
}
