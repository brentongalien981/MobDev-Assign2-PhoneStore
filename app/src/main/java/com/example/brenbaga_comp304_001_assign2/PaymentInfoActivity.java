package com.example.brenbaga_comp304_001_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PaymentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_info);


        // Set payment-type-radio-group event-handler.
        RadioGroup paymentTypeRadioGroup = findViewById(R.id.paymentTypeRadioGroup);

        paymentTypeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton cashRadioBtn = findViewById(R.id.paymentTypeCashRadioBtn);
                LinearLayout paymentCardDetailsLinearLayout = findViewById(R.id.paymentCardDetailsLinearLayout);

                paymentCardDetailsLinearLayout.setVisibility(View.VISIBLE);

                // Hide the card-details text-fields if "Cash" is chosen as payment-type.
                if (cashRadioBtn.isChecked()) {
                    paymentCardDetailsLinearLayout.setVisibility(View.GONE);
                }
            }
        });
    }


    public void onPayNow(View v) {
        Intent intent = new Intent(this, OrderConfirmationActivity.class);
        startActivity(intent);
    }
}