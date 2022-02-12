package com.example.brenbaga_comp304_001_assign2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {


    private final Context context;
    private ArrayList<PhoneModel> myDataSet;


    public MyRecyclerViewAdapter(Context context, ArrayList<PhoneModel> myDataSet) {
        this.context = context;
        this.myDataSet = myDataSet;
    }


    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Create a new view from layout "view_holder_phone_model_item".
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_phone_model_item, parent, false);

        MyRecyclerViewHolder myViewHolder = new MyRecyclerViewHolder(v);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, @SuppressLint("RecyclerView") int position) {

        PhoneModel phone = this.myDataSet.get(position);
        String displayedPhonePrice = "$" + String.valueOf(phone.price);

        // Set the controls.
        holder.phoneModelImageView.setImageResource(phone.imageResourceId);
        holder.phoneModelNameTextView.setText(phone.name);
        holder.phoneModelPriceTextView.setText(displayedPhonePrice);
        holder.sixFourGbRadioBtn.setChecked(true);


        // Set event-handlers for each phone-storage-radio-group.
        holder.phoneStorageRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                // Update the storage of the specific phone on phoneModelsDataSet.
                RadioButton selectedRadioBtn = ((Activity) context).findViewById(checkedId);
                phone.storage = selectedRadioBtn.getText().toString();
            }
        });


        // Set event-handlers for each phone-color-spinner.
        holder.phoneColorsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                // Update the color of the specific phone on phoneModelsDataSet.
                String[] phoneColors = context.getResources().getStringArray(R.array.phone_colors);
                String selectedColor = phoneColors[i];
                phone.color = selectedColor;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //
            }
        });



        // Set event-handlers for each select-phone-model-btn.
        holder.phoneModelSelectBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Set the selected-phone on MySharedPreferences.
                PhoneModel selectedPhone = new PhoneModel(phone.name, phone.price, phone.storage, phone.color, phone.imageResourceId, phone.brand);
                MySharedPreferences.setPhone(context, selectedPhone);

                // Go to checkout (phone-summary).
                Intent intent = new Intent(context, CheckoutActivity.class);
                context.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return this.myDataSet.size();
    }
}
