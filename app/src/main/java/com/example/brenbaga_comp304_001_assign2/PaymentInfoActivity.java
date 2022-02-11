package com.example.brenbaga_comp304_001_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PaymentInfoActivity extends AppCompatActivity {

    private String theBillingType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_info);

        // Set credit-card radio-btn initially checked.
        RadioButton creditCardRadioBtn = findViewById(R.id.paymentTypeCreditCardRadioBtn);
        creditCardRadioBtn.setChecked(true);

        this.theBillingType = creditCardRadioBtn.getText().toString();


        // Set payment-type-radio-group event-handler.
        RadioGroup paymentTypeRadioGroup = findViewById(R.id.paymentTypeRadioGroup);

        paymentTypeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedRadioBtnId) {

                RadioButton cashRadioBtn = findViewById(R.id.paymentTypeCashRadioBtn);
                LinearLayout paymentCardDetailsLinearLayout = findViewById(R.id.paymentCardDetailsLinearLayout);

                paymentCardDetailsLinearLayout.setVisibility(View.VISIBLE);

                // Hide the card-details text-fields if "Cash" is chosen as payment-type.
                if (cashRadioBtn.isChecked()) {
                    paymentCardDetailsLinearLayout.setVisibility(View.GONE);
                }


                // Set the billing-type-name.
                RadioButton selectedRadioBtn = findViewById(checkedRadioBtnId);
                theBillingType = selectedRadioBtn.getText().toString();
            }
        });
    }


    public void onPayNow(View v) {

        // Set the payment-info on MySharedPreferences.
        MySharedPreferences.setString(this, "paymentType", this.theBillingType);
        MySharedPreferences.setString(this, "paymentCardholderName", ((EditText) findViewById(R.id.paymentCardCustomerNameEditText)).getText().toString());
        MySharedPreferences.setString(this, "paymentCardNumber", ((EditText) findViewById(R.id.paymentCardNumberEditText)).getText().toString());
        MySharedPreferences.setString(this, "paymentExpiryMonth", ((EditText) findViewById(R.id.paymentCardExpiryDateMonthEditText)).getText().toString());
        MySharedPreferences.setString(this, "paymentExpiryYear", ((EditText) findViewById(R.id.paymentCardExpiryDateYearEditText)).getText().toString());
        MySharedPreferences.setString(this, "paymentCardCvc", ((EditText) findViewById(R.id.paymentCardCvcEditText)).getText().toString());


        Intent intent = new Intent(this, OrderConfirmationActivity.class);
        startActivity(intent);
    }
}