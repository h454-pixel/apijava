package com.example.practice_1.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abhi on 06 Sep 2017 006.
 */

public class RetroClient {

    /********https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=49c3c9be3cda4ebf986c1215fa83da55
     * URLS
     *******/

    private static final String ROOT_URL = "https://newsapi.org/v2/";

    /**
     * Get Retrofit Instance
     */

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



    /**
     * Get API Service
     *
     * @return API Service
     */
    public static  Myapi getApiService() {
        return getRetrofitInstance().create(Myapi.class);
    }





}
