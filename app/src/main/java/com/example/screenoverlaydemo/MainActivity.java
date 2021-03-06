package com.example.appandroidbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final int APP_PERMISSION_REQUEST = 102;
    private WebView webView;
    private Button backButton;
    private String website;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();

        String website = "https://www.google.ca";
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.sebview);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        WebChromeClient chromeWebClient = new WebChromeClient();
        webView.setWebChromeClient(chromeWebClient);

        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    return false;
            }
        });

        webView.setOnTouchListener((v, event) -> {
            Log.d("Sebug", "["+MotionEvent.actionToString(event.getAction())+"] [X:" + event.getX() + "] [Y:" + event.getY() + "] [Pressure:" + event.getPressure() + "]" + "[Xprecision:" + event.getXPrecision() + "] [Yprecision:" + event.getYPrecision() + "]");
            return false;
        });

        webView.loadUrl(website);
    }
}