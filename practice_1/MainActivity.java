package com.example.practice_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.practice_1.Model.Article;
import com.example.practice_1.Model.NewsModel;
import com.example.practice_1.Retrofit.Myapi;
import com.example.practice_1.Retrofit.RetroClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Myapi api;
    ArrayList<Article> newsList = new ArrayList<Article>();
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;




    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         recyclerView =(RecyclerView)findViewById(R.id.rcy_view);
        progressBar =(ProgressBar)findViewById(R.id.progress_circular_1);
         progressBar.setVisibility(View.VISIBLE);
        recyclerAdapter = new RecyclerAdapter(this, newsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerAdapter);


        api = RetroClient.getApiService();

            Call<NewsModel> newsCall = api.getNews("us", "business", "49c3c9be3cda4ebf986c1215fa83da55");
            newsCall.enqueue(new Callback<NewsModel>() {
                @Override
                public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                    //  if (response.code()                                                                    == 200 && response.body().getArticles() != null) {


                    if (response.isSuccessful() ) {
                        newsList.clear();
                        newsList.addAll(response.body().getArticles());
                        recyclerAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();

                        progressBar.setVisibility(View.GONE);

                    }


                }

                @Override
                public void onFailure(Call<NewsModel> call, Throwable t) {
                    progressBar.setVisibility(View.GONE);

                    Toast.makeText(MainActivity.this, "unsucces"+t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });


        }









    }
