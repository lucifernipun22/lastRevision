package com.nipun.extension;

import com.nipun.extension.model.dataX;

import java.util.Map;


import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;



public interface RepositoryApiService {

   @POST("/api/register")
   Call<dataX> setRepositoryList(@Query("username") String username, @Query("password") String password);

   @POST("/api/register")
   Call<dataX> getRepositoryList(@Query("id") String id, @Query("token") String token);



}