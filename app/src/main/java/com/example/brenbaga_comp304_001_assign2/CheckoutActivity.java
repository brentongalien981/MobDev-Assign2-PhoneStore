package com.example.brenbaga_comp304_001_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Instantiate the selected phone-model based on MySharedPreferences.
        PhoneModel phone = MySharedPreferences.getPhone(this);
        String displayedPhonePrice = String.valueOf(CheckoutActivity.roundMyDouble(phone.price, 2));


        // Set the controls.
        ((TextView) findViewById(R.id.phoneSummaryBrand)).setText(phone.brand);
        ((TextView) findViewById(R.id.phoneSummaryModelName)).setText(phone.name);
        ((TextView) findViewById(R.id.phoneSummaryPrice)).setText(displayedPhonePrice);
        ((TextView) findViewById(R.id.phoneSummaryStorage)).setText(phone.storage);
        ((TextView) findViewById(R.id.phoneSummaryColor)).setText(phone.color);
    }


    public void onFillCustomerInfo(View v) {
        // Go to customer-info.
        Intent intent = new Intent(this, CustomerInfoActivity.class);
        startActivity(intent);
    }


    public static double roundMyDouble(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}