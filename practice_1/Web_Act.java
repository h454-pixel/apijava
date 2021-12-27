
package com.example.practice_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web_Act extends AppCompatActivity {

    private WebView mWebview ;
    String url="";
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_);
       context =this;

    mWebview =(WebView)findViewById(R.id.web_view);


        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            url=bundle.getString("url");
        }
        final ProgressDialog pDialog = new ProgressDialog(context);
        pDialog.setTitle(context.getString(R.string.app_name));
        pDialog.setMessage("Loading...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);

        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pDialog.dismiss();
            }
        });


        mWebview.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(context, MainActivity.class);
        startActivity(intent);
       // overridePendingTransition(R.anim, R.anim.slide_out_right);
        finish();
    }


}