package com.nipun.secondevaluation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.nipun.secondevaluation.Fragment.AppleFragment
import com.nipun.secondevaluation.Fragment.BananaFragment

class SecondActivity : AppCompatActivity() , FragmentCommunicationListener {

    private var fragmentManager: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

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
        val eventinforrmationFragment = BananaFragment()
        eventinforrmationFragment.setListener(this)
        fragmentTransaction.add(R.id.flContainer2, eventinforrmationFragment, "EventFragment")
            .commit()
    }

    private fun initViews() {
        fragmentManager = supportFragmentManager
    }
}