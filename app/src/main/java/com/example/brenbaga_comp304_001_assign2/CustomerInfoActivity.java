package com.example.brenbaga_comp304_001_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CustomerInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
    }



    public void onGoToPaymentInfo(View v) {

        // Instantiate the BillingInfo obj.
        PhoneModel selectedPhone = new PhoneModel(phone.name, phone.price, phone.storage, phone.color, phone.imageResourceId, phone.brand);


        // Set the billing-info on MySharedPreferences.
        MySharedPreferences.setPhone(context, selectedPhone);


        // Go to payment-info.
        Intent intent = new Intent(this, PaymentInfoActivity.class);
        startActivity(intent);
    }
}