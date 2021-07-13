package com.nipun.fragmentevaluation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.nipun.fragmentevaluation.Fragment.EventInformationFragment;
import com.nipun.fragmentevaluation.Fragment.EventInvitationFragment;

public class MainActivity extends AppCompatActivity implements FragmentCommunicationListener  {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        launchEventDetailsFragment();
    }

    private void launchEventDetailsFragment() {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        EventInvitationFragment eventinforrmationFragment=new EventInvitationFragment();
        eventinforrmationFragment.setListener(this);
        fragmentTransaction.add(R.id.flContainer,eventinforrmationFragment,"EventFragment").commit();
    }

    private void initViews() {
        fragmentManager=getSupportFragmentManager();
    }

    @Override
    public void onDataReceived(Bundle bundle) {
        EventInformationFragment timeAndDateFragment=new EventInformationFragment();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        timeAndDateFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.flContainer,timeAndDateFragment,"TimeDateFragment").commit();
        timeAndDateFragment.setListenerSecond(this);
    }

    @Override
    public void onDataReceivedTwo(Bundle bundle) {

    }

    @Override
    public void onDataReceivedThree(Bundle bundle) {

    }
}