package com.example.physicswalla.apicalling;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {
    private static RetrofitObject retrofitObject=null;
    private Api api;


    public RetrofitObject() {

        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        api=retrofit.create(Api.class);
    }
    public static synchronized RetrofitObject getInstance() {
        if (retrofitObject == null) {
            retrofitObject = new RetrofitObject();
        }
        return retrofitObject;
    }

    public Api getMyApi() {
        return api;
    }

}
