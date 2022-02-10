package com.example.brenbaga_comp304_001_assign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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


        // TODO: Delete.
//        String[] myDataSet = new String[100];
//        for (int i = 0; i < myDataSet.length; i++) {
//            myDataSet[i] = "Item" + i;
//        }

        ArrayList<PhoneModel> myDataSet = PhoneModelDataStore.getModelsByBrand("iPhone");
//        PhoneModel[] myDataSet = new PhoneModel[phonesArrayList.size()];
//        myDataSet = phonesArrayList.toArray();


        myAdapter = new MyRecyclerViewAdapter(myDataSet);
        myRecyclerView.setAdapter(myAdapter);
    }
}