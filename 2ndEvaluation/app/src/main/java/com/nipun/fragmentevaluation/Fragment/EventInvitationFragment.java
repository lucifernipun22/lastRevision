package com.nipun.fragmentevaluation.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.nipun.fragmentevaluation.FragmentCommunicationListener;
import com.nipun.fragmentevaluation.R;


public class EventInvitationFragment extends Fragment {
    private EditText mEtEventName;
    private EditText mEtEventTime;
    private EditText mEtEventDate;
    private Button mBtnLaunchInformationFragment;
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
        return inflater.inflate(R.layout.fragment_event_invitation, container, false);
    }

    public void setListener(FragmentCommunicationListener listener){
        this.listener=listener;
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {

        mEtEventName=view.findViewById(R.id.name);
        mEtEventTime=view.findViewById(R.id.time);
        mEtEventDate=view.findViewById(R.id.date);
        mBtnLaunchInformationFragment=view.findViewById(R.id.btn1);
        mBtnLaunchInformationFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null && isDataValid()){
                    Bundle bundle=new Bundle();
                    bundle.putString("name",mEtEventName.getText().toString());
                    bundle.putString("time",mEtEventTime.getText().toString());
                    bundle.putString("date",mEtEventDate.getText().toString());

                    listener.onDataReceived(bundle);
                }
            }
        });
    }
    private boolean isDataValid(){
        if(mEtEventName.getText().toString().isEmpty()){
            mEtEventName.setError("Name is Mandatory");
            return false;
        }
        if(mEtEventTime.getText().toString().isEmpty()){
            mEtEventTime.setError("Time is Mandatory");
            return false;
        }
        if(mEtEventDate.getText().toString().isEmpty()){
            mEtEventDate.setError("Date is Mandatory");
            return false;
        }
        return true;
    }

}