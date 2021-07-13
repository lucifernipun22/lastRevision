package com.nipun.fragmentevaluation.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nipun.fragmentevaluation.Activity3;
import com.nipun.fragmentevaluation.FragmentCommunicationListener;
import com.nipun.fragmentevaluation.R;

public class EventInformationFragment extends Fragment {
    private EditText mEtPhone;
    private EditText mEtaddress;
    private Button mBtnNext;
    private String name;
    private TextView tvName;
    private TextView tvTime;
    private TextView tvDate;
    private String time;
    private String date;
    private Intent intent;
    private FragmentCommunicationListener listener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_event_information, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        getDataFromEventDetailsFragment();
        // tvName = setArguments();
        tvName.setText(name);
        tvTime.setText(time);
        tvDate.setText(date);
    }

    private void getDataFromEventDetailsFragment() {

        if (getArguments() != null) {
            name = getArguments().getString("name");
            time = getArguments().getString("time");
            date = getArguments().getString("date");

        }
    }

    private void initViews(View view) {
        mEtPhone = view.findViewById(R.id.phone);
        mEtaddress = view.findViewById(R.id.address);
        mBtnNext = view.findViewById(R.id.btn2);
        tvName = view.findViewById(R.id.tvName);
        tvDate = view.findViewById(R.id.tvdate);
        tvTime = view.findViewById(R.id.tvtime);


        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               launchPriceDetailsFragment();

            }
        });
    }

    private void launchPriceDetailsFragment() {
         /*intent = new Intent(getActivity(), Activity3.class);
         startActivity(intent);*/

        Bundle bundle = new Bundle();



        if(listener!=null && isDataValid()){
            bundle.putString("name",tvName.getText().toString());
            bundle.putString("time",tvTime.getText().toString());
            bundle.putString("date",tvDate.getText().toString());
            bundle.putString("phone",mEtPhone.getText().toString());
            bundle.putString("address",mEtaddress.getText().toString());
            listener.onDataReceivedThree(bundle);
        }

    }

    private boolean isDataValid() {
        if (mEtPhone.getText().toString().isEmpty()) {
            mEtPhone.setError("phone Empty");
            return false;
        }
        if (mEtaddress.getText().toString().isEmpty()) {
            mEtaddress.setError("address Empty");
            return false;
        }

        return true;
    }

    public void setListenerSecond(FragmentCommunicationListener listener) {
        this.listener = listener;
    }
}