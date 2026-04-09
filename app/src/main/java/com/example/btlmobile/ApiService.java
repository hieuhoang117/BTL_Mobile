package com.example.btlmobile;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/movies")
    Call<List<Movie>> getMostViewed();
}