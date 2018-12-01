package com.example.chenshuyu.dreamer.service;

import com.example.chenshuyu.dreamer.entity.Dreamer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("dream/query/")
    Call<Dreamer> getSearch(@Query("appid")String appid,@Query("keyword")String keyword);
}
