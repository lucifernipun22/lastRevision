package com.nipun.secondevaluation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.nipun.secondevaluation.Fragment.AppleFragment

class MainActivity : AppCompatActivity(), FragmentCommunicationListener {

    private var fragmentManager: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        launchEventDetailsFragment()
    }

    override fun onDataReceived(bundle: Bundle?) {

    }

    override fun onDataReceivedTwo(bundle: Bundle?) {

    }

    override fun onDataReceivedThree(bundle: Bundle?) {

    }

    private fun launchEventDetailsFragment() {
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        val eventinforrmationFragment = AppleFragment()
        eventinforrmationFragment.setListener(this)
        fragmentTransaction.add(R.id.flContainer, eventinforrmationFragment, "EventFragment")
            .commit()
    }

    private fun initViews() {
        fragmentManager = supportFragmentManager
    }
}