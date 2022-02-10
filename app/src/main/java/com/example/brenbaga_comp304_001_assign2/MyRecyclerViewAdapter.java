package com.example.brenbaga_comp304_001_assign2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

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
        holder.phoneModelImageView.setImageResource(phone.imageResourceId);
        holder.phoneModelNameTextView.setText(phone.name);
        holder.phoneModelPriceTextView.setText(String.valueOf(phone.price));
//        holder.phoneColorsSpinner.setTag(phone);


        // Set event-handlers for each spinner.
        holder.phoneColorsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

//                Phone tappedPhone = myDataSet.get(position);

                Log.w("CenPhone", "------------------------");
                Log.w("CenPhone", "BEFORE EVENT");
                for (int j = 0; j < myDataSet.size(); j++) {
                    PhoneModel jthPhone = myDataSet.get(j);
                    Log.w("CenPhone", "jthPhone.name ==> " + jthPhone.name);
                    Log.w("CenPhone", "jthPhone.color ==> " + jthPhone.color);
                }
                Log.w("CenPhone", "------------------------");

                Log.w("CenPhone", "phoneName ==> " + phone.name);
                Log.w("CenPhone", "phoneModelPosition ==> " + position);
                Log.w("CenPhone", "spinnerItemIndex ==> " + i);
                Log.w("CenPhone", "viewId ==> " + view.getId());
                Log.w("CenPhone", "view.getTag() ==> " + view.getTag());

                String[] phoneColors = context.getResources().getStringArray(R.array.phone_colors);
                String selectedColor = phoneColors[i];
                phone.color = selectedColor;


                Log.w("CenPhone", "------------------------");
                Log.w("CenPhone", "AFTER EVENT");
                for (int j = 0; j < myDataSet.size(); j++) {
                    PhoneModel jthPhone = myDataSet.get(j);
                    Log.w("CenPhone", "jthPhone.name ==> " + jthPhone.name);
                    Log.w("CenPhone", "jthPhone.color ==> " + jthPhone.color);
                }
                Log.w("CenPhone", "------------------------");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //
            }
        });
    }


    @Override
    public int getItemCount() {
        return this.myDataSet.size();
    }
}
