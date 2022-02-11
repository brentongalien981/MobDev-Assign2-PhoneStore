package com.example.brenbaga_comp304_001_assign2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentPhoneSummary extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phone_summary, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        PhoneModel phone = MySharedPreferences.getPhone(getActivity());

        // Set the textviews.
        ((TextView) getActivity().findViewById(R.id.orderSummaryPhoneName)).setText(phone.name);
        ((TextView) getActivity().findViewById(R.id.orderSummaryPhonePrice)).setText(String.valueOf(phone.price));
        ((TextView) getActivity().findViewById(R.id.orderSummaryPhoneStorage)).setText(phone.storage);
        ((TextView) getActivity().findViewById(R.id.orderSummaryPhoneColor)).setText(phone.color);
        ((TextView) getActivity().findViewById(R.id.orderSummaryPhoneBrand)).setText(phone.brand);
    }
}