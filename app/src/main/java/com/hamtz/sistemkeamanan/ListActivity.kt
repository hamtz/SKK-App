package com.hamtz.sistemkeamanan

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        webView = findViewById(R.id.listWebview)
        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                // Menggunakan WebViewClient untuk menangani permintaan URL
                return false
            }
        }


        // this will load the url of the website
//        webView.loadUrl("https://mamanialaundry.my.id/list-deteksi")
        webView.loadUrl("https://myshared.my.id/list-deteksi")

        webView.setWebChromeClient(WebChromeClient())

        // if you want to enable zoom feature
        webView.settings.setSupportZoom(true)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (event.getAction() === KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    if (webView.canGoBack()) {
                        webView.goBack()
                    } else {
                        finish()
                    }
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }

//    override fun onBackPressed() {
//        // if your webview can go back it will go back
//        if (webView.canGoBack())
//            webView.goBack()
//        // if your webview cannot go back
//        // it will exit the application
//        else
//            super.onBackPressed()
//    }
}