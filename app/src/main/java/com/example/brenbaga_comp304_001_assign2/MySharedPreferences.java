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



    public static void setBillingInfo(Context context, BillingInfoModel billing) {

        SharedPreferences myPreference = context.getSharedPreferences("CenPhone", 0);
        SharedPreferences.Editor prefEditor = myPreference.edit();

        prefEditor.putString("billingPreferredTitle", billing.preferredTitle);
        prefEditor.putString("billingFirstName", billing.firstName);
        prefEditor.putString("billingLastName", billing.lastName);
        prefEditor.putString("billingEmail", billing.email);
        prefEditor.putString("billingPhoneNumber", billing.phoneNumber);
        prefEditor.putString("billingStreet", billing.street);
        prefEditor.putString("billingCity", billing.city);
        prefEditor.putString("billingProvince", billing.province);
        prefEditor.putString("billingPostalCode", billing.postalCode);
        prefEditor.putBoolean("billingIsSameWithShipping", billing.isSameWithShipping);

        prefEditor.commit();
    }


    public static BillingInfoModel getBillingInfo(Context context) {

        SharedPreferences myPref = context.getSharedPreferences("CenPhone", context.MODE_PRIVATE);

        BillingInfoModel billing = new BillingInfoModel(
                myPref.getString("billingPreferredTitle", ""),
                myPref.getString("billingFirstName", ""),
                myPref.getString("billingLastName", ""),
                myPref.getString("billingEmail", ""),
                myPref.getString("billingPhoneNumber", ""),
                myPref.getString("billingStreet", ""),
                myPref.getString("billingCity", ""),
                myPref.getString("billingProvince", ""),
                myPref.getString("billingPostalCode", ""),
                myPref.getBoolean("billingIsSameWithShipping", false)
        );

        return billing;
    }
}
