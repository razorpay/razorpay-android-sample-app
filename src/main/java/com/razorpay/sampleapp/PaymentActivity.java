package com.razorpay.sampleapp;

import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.razorpay.Checkout;
import org.json.JSONObject;

public class PaymentActivity extends Activity
{
  final String public_key = "rzp_live_ILgsfZCZoFIKMb";

  public PaymentActivity(){}

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    // payment button created by you in xml layout
    View button = (View) findViewById(R.id.pay_btn);

    // you need to pass current activity in order to let razorpay create CheckoutActivity
    final Activity activity = this;
    final CheckoutFragment co = new CheckoutFragment();
    co.setPublicKey(public_key);

    button.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View arg0) {
        try{
          JSONObject options = new JSONObject("{" +
            "description: 'Demoing Charges'," +
            "image: 'https://rzp-mobile.s3.amazonaws.com/images/rzp.png'," +
            "currency: 'INR'}"
          );

          options.put("amount", "500");
          options.put("name", "Razorpay Corp");
          options.put("prefill", new JSONObject("{email: 'sm@razorpay.com', contact: '9876543210'}"));

          co.open(activity, options);

        } catch(Exception e){
          Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
          e.printStackTrace();
        }
      };
    });
  }
}
