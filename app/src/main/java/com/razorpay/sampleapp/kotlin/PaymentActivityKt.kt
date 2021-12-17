package com.razorpay.sampleapp.kotlin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.razorpay.Checkout
import com.razorpay.ExternalWalletListener
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import com.razorpay.sampleapp.R
import com.razorpay.sampleapp.databinding.ActivityPaymentBinding
import com.razorpay.sampleapp.databinding.PaymentActivityKtBinding
import org.json.JSONObject
import java.lang.Exception

class PaymentActivityKt : Activity(), ExternalWalletListener, PaymentResultWithDataListener {

    private val checkout: Checkout = Checkout()
    private lateinit var binding: PaymentActivityKtBinding
    private lateinit var alertDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PaymentActivityKtBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPayRzp.setOnClickListener {
            payWithRazorpay()
        }
        binding.tvNoteDesc.setOnClickListener {
            val httpIntent = Intent(Intent.ACTION_VIEW)
            httpIntent.data = Uri.parse("https://razorpay.com/sample-application/")
            startActivity(httpIntent)
        }
        binding.tvCodeType.text = "Kotlin Code"
    }

    private fun payWithRazorpay(){

        val activity = this
//        You can set the Key dynamically using the setKeyID function. Only do this if the key is not added in the AndroidManifest.xml
//        checkout.setKeyID("")
        try {
            val options = JSONObject()
            options.put("name", "Razorpay Corp")
            options.put("description", "Demoing Charges")
            options.put("send_sms_hash", true)
            options.put("allow_rotation", true)
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("currency", "INR")
            options.put("amount", "100")
            val retry = JSONObject()
            retry.put("enabled", false)
            retry.put("max_count", 0)
            options.put("retry", retry)
            val preFill = JSONObject()
            preFill.put("email", "test@razorpay.com")
            preFill.put("contact", "9876543210")
            options.put("prefill", preFill)
            checkout.open(activity, options)
        } catch (e: Exception) {
            Toast.makeText(activity, "Error in payment: " + e.message, Toast.LENGTH_SHORT)
                .show()
            e.printStackTrace()
        }
    }

    override fun onExternalWalletSelected(p0: String?, p1: PaymentData?) {
        try{
            AlertDialog.Builder(this).setTitle("External Wallet Selected").show()
        }catch (e: Exception){
            Log.e("EXCEPTION","External Wallet Exception: "+e.printStackTrace())

        }
    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        try{
            AlertDialog.Builder(this).setTitle("Payment Successful").setMessage("Payment ID: $p0 \n Signature: ${p1?.signature}").show()
        }catch (e: Exception){
            Log.e("EXCEPTION","Payment Success Exception: "+e.printStackTrace())
        }
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        try{
            AlertDialog.Builder(this).setTitle("Payment Failed").setMessage("Code: $p0 \n Description: $p1 \n Signature: ${p2?.signature}").show()
        }catch (e: Exception){
            Log.e("EXCEPTION","Payment Failed Exception: "+e.printStackTrace())
        }
    }


}

