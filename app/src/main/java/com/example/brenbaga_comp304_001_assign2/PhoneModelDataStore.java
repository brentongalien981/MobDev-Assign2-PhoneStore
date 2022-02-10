package com.example.brenbaga_comp304_001_assign2;

import java.util.ArrayList;

public class PhoneModelDataStore {

    public static ArrayList<PhoneModel> getModelsByBrand(String brand) {

        ArrayList<PhoneModel> models = new ArrayList<>();

        switch (brand) {
            case "iPhone":
                models.add(new PhoneModel("iPhone 13 Pro Max", 1499.99, "64GB", "Black", R.drawable.phone_model_iphone_13_pro_max));
                models.add(new PhoneModel("iPhone X", 1499.99, "64GB", "Black", R.drawable.phone_model_iphone_x));
                models.add(new PhoneModel("iPhone 8", 1499.99, "64GB", "Black", R.drawable.phone_model_iphone_8));
                break;
        }

        return models;
    }
}
