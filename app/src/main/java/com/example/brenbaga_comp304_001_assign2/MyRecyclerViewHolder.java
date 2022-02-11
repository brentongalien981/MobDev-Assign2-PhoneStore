package com.example.brenbaga_comp304_001_assign2;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

    public ImageView phoneModelImageView;
    public TextView phoneModelNameTextView;
    public TextView phoneModelPriceTextView;
    public RadioGroup phoneStorageRadioGroup;
    public Spinner phoneColorsSpinner;
    public Button phoneModelSelectBtn;

    public MyRecyclerViewHolder(View v) {
        super(v);
        phoneModelImageView = v.findViewById(R.id.phoneModelImageView);
        phoneModelNameTextView = v.findViewById(R.id.phoneModelNameTextView);
        phoneModelPriceTextView = v.findViewById(R.id.phoneModelPriceTextView);
        phoneStorageRadioGroup = v.findViewById(R.id.phoneModelStorageRadioGroup);
        phoneColorsSpinner = v.findViewById(R.id.phoneColorsSpinner);
        phoneModelSelectBtn = v.findViewById(R.id.selectPhoneBtn);
    }

}
