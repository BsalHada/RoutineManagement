package com.example.finalassignment.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalassignment.R;

public class SampleMapActivity extends AppCompatActivity {

    private WebView mWebView;
    String loadMap = "https://goo.gl/maps/7nVdr4XCehQoB6o37";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_map);

        mWebView = findViewById(R.id.mapView);
        mWebView.loadUrl(loadMap);

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());


    }
}
