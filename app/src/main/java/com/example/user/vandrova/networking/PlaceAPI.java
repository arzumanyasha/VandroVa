package com.example.user.vandrova.networking;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceAPI {
    @GET("/maps/api/place/nearbysearch/json?radius=1500&type=restaurant&keyword=cruise")
    Call<JsonObject> getPlace(@Query("location") String location, @Query("key") String key);

    @GET("venues/explore")
    Call<JsonObject> getFoursquarePlace(@Query("ll") String location);
}
