package com.nipun.fragmentevaluation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.nipun.fragmentevaluation.Fragment.EventConfirmationFragment;
import com.nipun.fragmentevaluation.Fragment.EventInformationFragment;

public class Activity3 extends AppCompatActivity implements FragmentCommunicationListener {
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        launchEventDetailsFragment();
        initViews();

    }

    private void launchEventDetailsFragment() {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        EventConfirmationFragment eventinforrmationFragment=new EventConfirmationFragment();
        eventinforrmationFragment.setListenerThird(this);
        fragmentTransaction.add(R.id.flContainer3,eventinforrmationFragment,"EventFragment").commit();
    }

    @Override
    public void onDataReceived(Bundle bundle) {

    }

    @Override
    public void onDataReceivedTwo(Bundle bundle) {

    }

    @Override
    public void onDataReceivedThree(Bundle bundle) {
        EventConfirmationFragment timeAndDateFragment=new EventConfirmationFragment();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        timeAndDateFragment.setArguments(bundle);

        fragmentTransaction.add(R.id.flContainer3,timeAndDateFragment,"TimeDateFragment").commit();
        timeAndDateFragment.setListenerThird(this);
    }

    private void initViews() {
        fragmentManager=getSupportFragmentManager();
    }
}