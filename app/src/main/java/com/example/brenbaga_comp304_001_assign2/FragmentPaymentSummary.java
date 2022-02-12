package com.example.brenbaga_comp304_001_assign2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentPaymentSummary extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_summary, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        // Set the textviews.
        String paymentType = MySharedPreferences.getString(getActivity(), "paymentType");

        ((TextView) getActivity().findViewById(R.id.orderSummaryPaymentType)).setText(paymentType);

        if (!paymentType.equals("Cash")) {
            ((TextView) getActivity().findViewById(R.id.orderSummaryPaymentCardholderName)).setText(MySharedPreferences.getString(getActivity(), "paymentCardholderName"));
            ((TextView) getActivity().findViewById(R.id.orderSummaryPaymentCardNumber)).setText(MySharedPreferences.getString(getActivity(), "paymentCardNumber"));
            ((TextView) getActivity().findViewById(R.id.orderSummaryPaymentExpiryMonth)).setText("Expiry Month: " + MySharedPreferences.getString(getActivity(), "paymentExpiryMonth"));
            ((TextView) getActivity().findViewById(R.id.orderSummaryPaymentExpiryYear)).setText("Expiry Year: " + MySharedPreferences.getString(getActivity(), "paymentExpiryYear"));
            ((TextView) getActivity().findViewById(R.id.orderSummaryPaymentCvc)).setText("CVC : " + MySharedPreferences.getString(getActivity(), "paymentCardCvc"));
        }
    }
}