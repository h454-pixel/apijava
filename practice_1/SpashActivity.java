package com.example.practice_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SpashActivity extends AppCompatActivity {

    Handler handler;

    TextView textView ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_spash);

        textView = (TextView)findViewById(R.id.text_view_splash);

        handler =  new Handler( );
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SpashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        } , 3000);



    }
}