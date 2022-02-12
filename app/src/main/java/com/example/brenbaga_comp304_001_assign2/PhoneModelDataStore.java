package com.example.brenbaga_comp304_001_assign2;

import java.util.ArrayList;

public class PhoneModelDataStore {

    public static ArrayList<PhoneModel> getModelsByBrand(String brand) {

        ArrayList<PhoneModel> models = new ArrayList<>();

        switch (brand) {
            case "iPhone":
                models.add(new PhoneModel("iPhone 13 Pro Max", 1499.99, "64GB", "Black", R.drawable.phone_model_iphone_13_pro_max, "iPhone"));
                models.add(new PhoneModel("iPhone X", 1499.99, "64GB", "Black", R.drawable.phone_model_iphone_x, "iPhone"));
                models.add(new PhoneModel("iPhone 8", 1499.99, "64GB", "Black", R.drawable.phone_model_iphone_8, "iPhone"));
                break;
            case "Samsung":
                models.add(new PhoneModel("Samsung Galaxy S22+", 1499.99, "64GB", "Black", R.drawable.samsung_galaxy_s22_plus, "Samsung"));
                models.add(new PhoneModel("Samsung Galaxy S20", 1499.99, "64GB", "Black", R.drawable.samsung_galaxy_s20, "Samsung"));
                models.add(new PhoneModel("Samsung Galaxy Z Fold3 5G", 1499.99, "64GB", "Black", R.drawable.samsung_galaxy_z_fold3_5g, "Samsung"));
                break;
            case "Google Pixel":
                models.add(new PhoneModel("Google Pixel 6 Pro", 1499.99, "64GB", "Black", R.drawable.google_pixel_6_pro, "Google Pixel"));
                models.add(new PhoneModel("Google Pixel 6", 1499.99, "64GB", "Black", R.drawable.google_pixel_6, "Google Pixel"));
                models.add(new PhoneModel("Google Pixel 4", 1499.99, "64GB", "Black", R.drawable.google_pixel_4, "Google Pixel"));
                break;
            case "Huawei":
                models.add(new PhoneModel("Huawei P40 Pro", 1499.99, "64GB", "Black", R.drawable.huawei_p40_pro, "Huawei"));
                models.add(new PhoneModel("Huawei P30 Pro", 1499.99, "64GB", "Black", R.drawable.huawei_p30_pro, "Huawei"));
                models.add(new PhoneModel("Huawei P20 Pro", 1499.99, "64GB", "Black", R.drawable.huawei_p20_pro, "Huawei"));
                break;
        }

        return models;
    }
}
