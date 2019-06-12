package com.example.webviewbuttonclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webview;

    private String htmlData = "";//Your html string
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("onCreate","Start");
        webview = findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setPluginState(WebSettings.PluginState.ON);
        webview.loadData(htmlData,"text/html",null);
        webview.setWebViewClient(new WebViewClient());//Block Open Chrome App
        Log.i("onCreate","WebView LoadData");
        final String javascript = "document.getElementsByName('submit')[0].click()"; //Click function for javascript
        Log.i("onCreate","Click Function");
        webview.post(new Runnable() {
            @Override
            public void run() {
                webview.loadUrl("javascript:" + javascript);//Start click action
                Log.i("onCreate","Start Click Action");
            }
        });
    }
}
