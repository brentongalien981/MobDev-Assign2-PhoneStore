package com.example.brenbaga_comp304_001_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BrandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);
    }


    // Set the options menu.
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_brands, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        int brandImageResourceId = R.drawable.brand_iphone;

        switch (item.getItemId()) {
            case R.id.Samsung:
                brandImageResourceId = R.drawable.brand_samsung;
                break;
            case R.id.GooglePixel:
                brandImageResourceId = R.drawable.brand_google;
                break;
            case R.id.Huawei:
                brandImageResourceId = R.drawable.brand_huawei;
                break;
        }

        // Set BrandTextView.
        TextView brandNameTextView = (TextView) findViewById(R.id.brandNameTextView);
        brandNameTextView.setText(item.getTitle());

        // Set BrandImageView.
        ImageView iv = (ImageView) findViewById(R.id.phoneBrandImageView);
        iv.setImageResource(brandImageResourceId);

        // Set selected-brand on MySharedPreferences.
        MySharedPreferences.setString(this,"selectedBrand", item.getTitle().toString());

        return true;
    }



    public void handleChooseModel(View v) {
        Intent myIntent = new Intent(this, PhoneModelsActivity.class);
        startActivity(myIntent);
    }
}