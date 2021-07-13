package com.nipun.fragmentevaluation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.nipun.fragmentevaluation.Fragment.EventConfirmationFragment;
import com.nipun.fragmentevaluation.Fragment.EventInformationFragment;
import com.nipun.fragmentevaluation.Fragment.EventInvitationFragment;

public class Activity2 extends AppCompatActivity implements FragmentCommunicationListener{
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        launchEventDetailsFragment();
       initViews();

    }

    private void launchEventDetailsFragment() {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        EventInformationFragment eventinforrmationFragment=new EventInformationFragment();
        eventinforrmationFragment.setListenerSecond(this);
        fragmentTransaction.add(R.id.flContainer2,eventinforrmationFragment,"EventFragment").commit();
    }

    @Override
    public void onDataReceived(Bundle bundle) {

    }

    @Override
    public void onDataReceivedTwo(Bundle bundle) {
       /* EventConfirmationFragment timeAndDateFragment=new EventConfirmationFragment();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        timeAndDateFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.flContainer2,timeAndDateFragment,"TimeDateFragment").commit();
        timeAndDateFragment.setListenerThird(this);*/

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