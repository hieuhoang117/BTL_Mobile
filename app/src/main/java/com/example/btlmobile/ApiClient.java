package com.example.btlmobile;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    /*private static final String BASE_URL = "http://192.168.1.21:5000/";*/
    private static final String BASE_URL = "http://192.168.1.12:5000/";

    public static Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}