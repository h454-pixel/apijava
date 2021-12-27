package com.example.practice_1.Retrofit;

import com.example.practice_1.Model.NewsModel;

import java.lang.annotation.Target;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Myapi {



 //("top-headlines?country=us&category=business&apiKey=49c3c9be3cda4ebf986c1215fa83da55")

 @GET("top-headlines")
 Call<NewsModel> getNews(@Query("country") String country1, @Query("category")String category1,
                         @Query("apiKey") String key );


       // ("top-headlines")
       //Call<NewsModel>getNeww(@Body NewsModel newsModel);

}
