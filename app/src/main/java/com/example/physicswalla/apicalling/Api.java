package com.example.physicswalla.apicalling;

import com.example.physicswalla.model.ModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;



public interface Api {

    String BASE_URL="https://my-json-server.typicode.com/easygautam/data/";
    @GET("users")
    Call<List<ModelClass>>getData();

}
