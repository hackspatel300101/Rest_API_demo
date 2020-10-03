package com.example.rest_api_demo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("/photos")
    Call<List<PhotoModel>> getAllPhotos();

}
