package com.hamtz.sistemkeamanan

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        webView = findViewById(R.id.webview)
        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                // Handle the error here, for example, show an error message or load a default page.
                // You can customize this based on your application's requirements.
                Toast.makeText(this@HomeActivity, "Error loading the page", Toast.LENGTH_SHORT).show()
                // You can load a default page or do any other action here.
                // webView.loadUrl("file:///android_asset/error_page.html")
            }
        }

        // Load the URL
        webView.loadUrl("https://myshared.my.id")
        webView.settings.javaScriptEnabled = true
        webView.setWebChromeClient(WebChromeClient())
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