package com.example.brenbaga_comp304_001_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CustomerInfoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private BillingInfoModel theBillingInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        this.theBillingInfo = new BillingInfoModel();

        Spinner customerPreferredTitleSpinner = findViewById(R.id.customerPreferredTitleSpinner);
        customerPreferredTitleSpinner.setOnItemSelectedListener(this);
    }


    public void onGoToPaymentInfo(View v) {

        // Instantiate the BillingInfo obj.
        this.theBillingInfo.firstName = ((EditText) findViewById(R.id.customerFirstNameEditText)).getText().toString();
        this.theBillingInfo.lastName = ((EditText) findViewById(R.id.customerLastNameEditText)).getText().toString();
        this.theBillingInfo.email = ((EditText) findViewById(R.id.customerEmailEditText)).getText().toString();
        this.theBillingInfo.phoneNumber = ((EditText) findViewById(R.id.customerPhoneEditText)).getText().toString();
        this.theBillingInfo.street = ((EditText) findViewById(R.id.customerStreetEditText)).getText().toString();
        this.theBillingInfo.city = ((EditText) findViewById(R.id.customerCityEditText)).getText().toString();
        this.theBillingInfo.province = ((EditText) findViewById(R.id.customerProvinceEditText)).getText().toString();
        this.theBillingInfo.postalCode = ((EditText) findViewById(R.id.customerPostalCodeEditText)).getText().toString();
        this.theBillingInfo.isSameWithShipping = ((CheckBox) findViewById(R.id.isSameAsShippingCheckBox)).isChecked();


        // Set the billing-info on MySharedPreferences.
        MySharedPreferences.setBillingInfo(this, this.theBillingInfo);


        // Go to payment-info.
        Intent intent = new Intent(this, PaymentInfoActivity.class);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        // Set billing-info's preferred title.
        String[] customerTitles = getResources().getStringArray(R.array.customer_preferred_titles);
        this.theBillingInfo.preferredTitle = customerTitles[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}