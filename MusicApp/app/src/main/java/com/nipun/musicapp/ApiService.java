package com.nipun.musicapp;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/search")
    Call<Response> getUser(@Query("term") String str);

}
