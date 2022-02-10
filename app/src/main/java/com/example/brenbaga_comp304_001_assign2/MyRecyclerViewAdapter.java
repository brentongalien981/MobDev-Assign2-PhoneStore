package com.example.brenbaga_comp304_001_assign2;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {

//    private final PhoneModel[] myDataSet;
    private final ArrayList<PhoneModel> myDataSet;

    public MyRecyclerViewAdapter(ArrayList<PhoneModel> myDataSet) {
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
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {

        PhoneModel phone = this.myDataSet.get(position);
        holder.phoneModelNameTextView.setText(phone.name);
        holder.phoneModelImageView.setImageResource(phone.imageResourceId);

    }


    @Override
    public int getItemCount() {
        return this.myDataSet.size();
    }
}
