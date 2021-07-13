package com.nipun.fragmentevaluation.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nipun.fragmentevaluation.FragmentCommunicationListener;
import com.nipun.fragmentevaluation.R;

public class EventConfirmationFragment extends Fragment {
    private FragmentCommunicationListener listener;
    private TextView tvName;
    private TextView tvTime;
    private TextView tvDate;
    private TextView tvaddress;
    private TextView tvphone;
    private String name;
    private String time;
    private String date;
    private String address;
    private String phone;
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
        return inflater.inflate(R.layout.fragment_event_confirmation, container, false);
    }


    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        getDataFromEventDetailsFragment();
        tvName.setText(name);
        tvTime.setText(time);
        tvDate.setText(date);
        tvphone.setText(phone);
        tvaddress.setText(address);
    }

    private void getDataFromEventDetailsFragment() {
        if (getArguments() != null) {
            name = getArguments().getString("name");
            time = getArguments().getString("time");
            date = getArguments().getString("date");
            address = getArguments().getString("address");
            phone = getArguments().getString("phone");

        }
    }

    private void initView(View view) {
        tvName = view.findViewById(R.id.tvName1);
        tvTime = view.findViewById(R.id.tvtime1);
        tvDate = view.findViewById(R.id.tvdate1);
        tvaddress = view.findViewById(R.id.tvaddress1);
        tvphone = view.findViewById(R.id.tvphone1);

    }

    public void setListenerThird(FragmentCommunicationListener listener) {
        this.listener = listener;
    }
}