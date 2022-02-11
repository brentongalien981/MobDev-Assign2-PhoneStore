package com.example.brenbaga_comp304_001_assign2;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    public static void setString(Context context, String key, String val) {

        // Set shared-preferences.
        SharedPreferences myPreference = context.getSharedPreferences("CenPhone", 0);
        SharedPreferences.Editor prefEditor = myPreference.edit();

        // Set the new entry.
        prefEditor.putString(key, val);
        prefEditor.commit();
    }


    public static String getString(Context context, String key) {

        SharedPreferences myPref = context.getSharedPreferences("CenPhone", context.MODE_PRIVATE);
        return myPref.getString(key, "");
    }


    public static void setPhone(Context context, PhoneModel phone) {

        SharedPreferences myPreference = context.getSharedPreferences("CenPhone", 0);
        SharedPreferences.Editor prefEditor = myPreference.edit();

        prefEditor.putString("phoneBrand", phone.brand);
        prefEditor.putString("phoneName", phone.name);
        prefEditor.putFloat("phonePrice", (float) phone.price);
        prefEditor.putString("phoneColor", phone.color);
        prefEditor.putString("phoneStorage", phone.storage);
        prefEditor.putInt("phoneImageResourceId", phone.imageResourceId);
        prefEditor.commit();
    }


    public static PhoneModel getPhone(Context context) {

        SharedPreferences myPref = context.getSharedPreferences("CenPhone", context.MODE_PRIVATE);

        PhoneModel phone = new PhoneModel(
                myPref.getString("phoneName", ""),
                (double) myPref.getFloat("phonePrice", 0),
                myPref.getString("phoneStorage", ""),
                myPref.getString("phoneColor", ""),
                myPref.getInt("phoneImageResourceId", -1),
                myPref.getString("phoneBrand", ""));

        return phone;
    }
}
