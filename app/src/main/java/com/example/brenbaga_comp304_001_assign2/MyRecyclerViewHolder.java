package com.example.brenbaga_comp304_001_assign2;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView phoneModelNameTextView;
    public ImageView phoneModelImageView;

    public MyRecyclerViewHolder(View v) {
        super(v);
        phoneModelNameTextView = v.findViewById(R.id.phoneModelNameTextView);
        phoneModelImageView = v.findViewById(R.id.phoneModelImageView);

    }

}
