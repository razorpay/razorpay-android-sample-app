package com.razorpay.sampleapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.razorpay.sampleapp.java.PaymentActivity

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_java).setOnClickListener {
            startActivity(Intent(this, PaymentActivity::class.java))
        }

        findViewById<Button>(R.id.btn_kotlin).setOnClickListener {
            startActivity(Intent(this, com.razorpay.sampleapp.kotlin.PaymentActivity::class.java))
        }

        findViewById<Button>(R.id.btn_webview_activity).setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
    }
}