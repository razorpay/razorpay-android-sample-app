package com.razorpay.sampleapp;

import com.razorpay.Checkout;
import android.widget.Toast;

public class CheckoutFragment extends Checkout {

  // override onSuccess method to capture razorpay_payment_id
  public void onSuccess(String razorpay_payment_id){
    Toast.makeText(getActivity(), "Payment Successful: " + razorpay_payment_id, Toast.LENGTH_SHORT).show();
    // post razorpay_payment_id to your server or something.
  }

  //
  // onError will be invoked in following cases:
  // 1. back or close button pressed i.e. user cancels payment form (code = Activity.RESULT_CANCELED)
  // 2. network error while loading checkout form (code = 2)
  //
  // onError isn't invoked in case of payment authentication failure, rather error is displayed on checkout form and customer can reattempt payment.

  public void onError(int code, String response){
    Toast.makeText(getActivity(), "Error " + Integer.toString(code) + ": " + response, Toast.LENGTH_SHORT).show();
  }
};
