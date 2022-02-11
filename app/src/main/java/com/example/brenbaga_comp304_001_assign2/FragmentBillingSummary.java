package com.example.brenbaga_comp304_001_assign2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentBillingSummary extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billing_summary, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        // Instantiate the billing-info-object.
        BillingInfoModel billing = MySharedPreferences.getBillingInfo(getActivity());


        // Set the textviews.
        ((TextView) getActivity().findViewById(R.id.orderSummaryCustomerTitle)).setText(billing.preferredTitle);
        ((TextView) getActivity().findViewById(R.id.orderSummaryFirstName)).setText(billing.firstName);
        ((TextView) getActivity().findViewById(R.id.orderSummaryLastName)).setText(billing.lastName);
        ((TextView) getActivity().findViewById(R.id.orderSummaryEmail)).setText(billing.email);

        ((TextView) getActivity().findViewById(R.id.orderSummaryPhone)).setText(billing.phoneNumber);
        ((TextView) getActivity().findViewById(R.id.orderSummaryStreet)).setText(billing.street);
        ((TextView) getActivity().findViewById(R.id.orderSummaryCity)).setText(billing.city);
        ((TextView) getActivity().findViewById(R.id.orderSummaryProvince)).setText(billing.province);

        ((TextView) getActivity().findViewById(R.id.orderSummaryPostal)).setText(billing.postalCode);
        ((TextView) getActivity().findViewById(R.id.orderSummarySameShipping)).setText("Same as shipping: " + String.valueOf(billing.isSameWithShipping));
    }
}