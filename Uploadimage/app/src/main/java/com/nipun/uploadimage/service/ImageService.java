package com.nipun.uploadimage.service;


import com.nipun.uploadimage.model.ImageResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


public interface ImageService {
    @Multipart
    @Headers({
            "Authorization: Client-ID 956e21d90e840ce"
    })
    @POST("image")
    Call<ImageResponse> postImage(
            @Query("album") String albumId,
            @Query("account_url") String username,
            @Part MultipartBody.Part file);


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.imgur.com/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}