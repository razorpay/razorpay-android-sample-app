package com.razorpay.sampleapp;

import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.razorpay.Checkout;
import io.fabric.sdk.android.Fabric;
import org.json.JSONObject;

public class PaymentActivity extends Activity
{

  public PaymentActivity(){}

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    Fabric.with(this, new Crashlytics());
    setContentView(R.layout.main);

    // payment button created by you in xml layout
    View button = (View) findViewById(R.id.pay_btn);

    button.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View arg0) {
        startPayment();
      };
    });
  }

  public void startPayment(){
    /**
     * Replace with your public key
     */
    final String public_key = "rzp_live_ILgsfZCZoFIKMb";

    /**
     * You need to pass current activity in order to let razorpay create CheckoutActivity
     */
    final Activity activity = this;

    final Checkout co = new Checkout();
    co.setPublicKey(public_key);

    try{
      JSONObject options = new JSONObject("{" +
        "description: 'Demoing Charges'," +
        "image: 'https://rzp-mobile.s3.amazonaws.com/images/rzp.png'," +
        "currency: 'INR'}"
      );

      options.put("amount", "100");
      options.put("name", "Razorpay Corp");
      options.put("prefill", new JSONObject("{email: 'sm@razorpay.com', contact: '9876543210'}"));

      co.open(activity, options);

    } catch(Exception e){
      Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
      e.printStackTrace();
    }
  }

  /**
  * The name of the function has to be
  *   onPaymentSuccess
  * Wrap your code in try catch, as shown, to ensure that this method runs correctly
  */
  public void onPaymentSuccess(String razorpayPaymentID){
    try {
      Toast.makeText(this, "Payment Successful: " + razorpayPaymentID, Toast.LENGTH_SHORT).show();
    }
    catch (Exception e){
      Log.e("com.merchant", e.getMessage(), e);
    }
  }

  /**
  * The name of the function has to be
  *   onPaymentError
  * Wrap your code in try catch, as shown, to ensure that this method runs correctly
  */
  public void onPaymentError(int code, String response){
    try {
      Toast.makeText(this, "Payment failed: " + Integer.toString(code) + " " + response, Toast.LENGTH_SHORT).show();
    }
    catch (Exception e){
      Log.e("com.merchant", e.getMessage(), e);
    }
  }
}
