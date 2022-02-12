package com.example.brenbaga_comp304_001_assign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhoneModelsActivity extends AppCompatActivity {


    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_models);

        myRecyclerView = (RecyclerView) findViewById(R.id.phoneModelsRecyclerView);

        // Set view's layout manager.
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);


        // Set the Recycler Adapter, Holder and event-handlers.
        String selectedBrand = MySharedPreferences.getString(this, "selectedBrand");
        ArrayList<PhoneModel> myDataSet = PhoneModelDataStore.getModelsByBrand(selectedBrand);
        myAdapter = new MyRecyclerViewAdapter(this, myDataSet);
        myRecyclerView.setAdapter(myAdapter);
    }
}