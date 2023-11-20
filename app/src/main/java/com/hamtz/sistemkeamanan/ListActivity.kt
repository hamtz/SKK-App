package com.hamtz.sistemkeamanan

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class ListActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        webView = findViewById(R.id.listWebview)
        webView.webViewClient = WebViewClient()

        // this will load the url of the website
//        webView.loadUrl("https://mamanialaundry.my.id/list-deteksi")
        webView.loadUrl("https://myshared.my.id/list-deteksi")
        // this will enable the javascript settings, it can also allow xss vulnerabilities
        webView.settings.javaScriptEnabled = true

        webView.setWebChromeClient(WebChromeClient())

        // if you want to enable zoom feature
        webView.settings.setSupportZoom(true)
    }

    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (webView.canGoBack())
            webView.goBack()
        // if your webview cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    }
}