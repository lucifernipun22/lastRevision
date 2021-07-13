package com.nipun.extension;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryApiMaker {

    public static final String BASE_URL = "https://reqres.in/";

    private Retrofit retrofit;

    public RepositoryApiMaker() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RepositoryApiService getService() {

        return retrofit.create(RepositoryApiService.class);
    }
}