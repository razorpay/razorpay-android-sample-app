package com.razorpay.sampleapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WebViewActivity : Activity() {

    private val webviewClient = object:WebViewClient(){
        override fun shouldOverrideUrlLoading(view: android.webkit.WebView?, url: String?): Boolean {
            return super.shouldOverrideUrlLoading(view, url)
        }

        override fun shouldOverrideUrlLoading(
            view: android.webkit.WebView?,
            request: android.webkit.WebResourceRequest?
        ): Boolean {
            if(request?.url?.scheme != "https" && request?.url?.scheme != "http") {
                // Handle the URL as needed
                this@WebViewActivity.startActivity(Intent(Intent.ACTION_VIEW, request?.url))
                return true // Indicate that you've handled the URL
            }
            return super.shouldOverrideUrlLoading(view, request)
        }


    }

    private lateinit var etUrl: EditText
    private lateinit var webView: WebView
    private lateinit var btnGo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        etUrl = findViewById<EditText>(R.id.et_url)
        webView = findViewById<WebView>(R.id.webview)
        btnGo = findViewById(R.id.btn_submit_url)
        btnGo.setOnClickListener {
            webView.webViewClient = webviewClient
            webView.settings.javaScriptEnabled = true
            webView.settings.domStorageEnabled = true
            WebView.setWebContentsDebuggingEnabled(true)
            webView.loadUrl(etUrl.text.toString())
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}