package com.example.brenbaga_comp304_001_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        PhoneModel phone = MySharedPreferences.getPhone(this);
        Log.w("CenPhone", "CheckoutActivity: phone.name ==> " + phone.name);
        Log.w("CenPhone", "CheckoutActivity: phone.brand ==> " + phone.brand);
        Log.w("CenPhone", "CheckoutActivity: phone.storage ==> " + phone.storage);
        Log.w("CenPhone", "CheckoutActivity: phone.color ==> " + phone.color);
    }
}