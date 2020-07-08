package com.razorpay.sampleapp.java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import com.razorpay.sampleapp.R;
import com.razorpay.sampleapp.databinding.ActivityHomePageBinding;

import org.json.JSONObject;

public class ActivityHomePage extends AppCompatActivity implements PaymentResultListener {

    private ActivityHomePageBinding binding;
    private String imgUrl="https://s3.amazonaws.com/rzp-mobile/images/rzp.png";
    private String companyName="Razorpay Online Store";
    private String color= "#2B83EA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home_page);
        binding.btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHomePage.this,ActivitySettings.class);
                startActivityForResult(intent, 100);
            }
        });
        binding.btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnCheckout.setText("Processing");
                startPayment();
            }
        });
    }

    private void startPayment() {

        final Activity activity = this;

        final Checkout co = new Checkout();

        try {
            JSONObject options = new JSONObject();
            options.put("name", companyName);
            options.put("description", "Final Charges");
            //You can omit the image option to fetch the image from dashboard
            options.put("image",imgUrl);
            options.put("currency", "INR");
            options.put("amount", "100");

            JSONObject preFill = new JSONObject();
            preFill.put("email", "test@razorpay.com");
            preFill.put("contact", "9876543210");

            options.put("prefill", preFill);

            JSONObject theme = new JSONObject();
            theme.put("color",color);
            options.put("theme",theme);

            co.open(activity, options);
        } catch (Exception e) {
            Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT)
                    .show();
            e.printStackTrace();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1000) {
            if (data!=null) {
                imgUrl = data.getStringExtra("imageURL");
                companyName = data.getStringExtra("companyName");
                color = data.getStringExtra("color");
            }
        }
    }



    @Override
    public void onPaymentSuccess(String s) {
        binding.btnCheckout.setText("Pay now");
        Toast.makeText(ActivityHomePage.this, "Payment succesfull "+s,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        binding.btnCheckout.setText("Pay now");
        Toast.makeText(ActivityHomePage.this, "Payment unsuccessful "+s,Toast.LENGTH_LONG).show();
    }
}
