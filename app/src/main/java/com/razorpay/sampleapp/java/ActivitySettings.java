package com.razorpay.sampleapp.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.razorpay.sampleapp.R;
import com.razorpay.sampleapp.databinding.ActivitySettingsBinding;

public class ActivitySettings extends AppCompatActivity {

    private ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings);
        binding.ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSettings();
            }
        });
        binding.etColor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() >=6) {
                    String color = editable.toString();
                    color = "#"+color;
                    binding.ivColorEx.setBackgroundColor(Color.parseColor(color));
                }
            }
        });
        binding.btnSaveSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSettings();
            }
        });
    }

    private void saveSettings() {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(binding.etImageurl.getText().toString())){
            intent.putExtra("imageURL",binding.etImageurl.getText().toString());
        }else{
            intent.putExtra("imageURL","https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
        }
        if (TextUtils.isEmpty(binding.etCompanyName.getText().toString())){
            intent.putExtra("companyName","Razorpay Online Store");

        }else{
            intent.putExtra("companyName",binding.etCompanyName.getText().toString());
        }
        if (binding.etColor.getText().toString().length()!=6){
            Toast.makeText(this,"Please enter a correct color hex value",Toast.LENGTH_LONG).show();
        }else{
            intent.putExtra("color","#"+binding.etColor.getText().toString());
            setResult(1000,intent);
            finish();
        }

    }
}
