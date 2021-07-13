package com.nipun.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    val liveData1 = MutableLiveData<String>()
    val liveData2 = MutableLiveData<String>()

    private val observer1 = Observer<String> {
        it?.let {
            tvLiveDataOne.text = it
        }
    }

    private val observer2 = Observer<String> {
        it?.let {
            tvLiveDataTwo.text = it
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        liveData1.observe(this, observer1)
        liveData2.observe(this, observer2)
        initListeners()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnControlFragment -> {
                launchOrPopFragment()
            }

            R.id.btnGenerateOne -> {
                liveData1.value = (1..100).random().toString()
            }
            R.id.btnGenerateTwo -> {
                liveData2.postValue((1..100).random().toString())
            }
        }
    }

    private fun initListeners() {
        btnControlFragment.setOnClickListener(this)
        btnGenerateOne.setOnClickListener(this)
        btnGenerateTwo.setOnClickListener(this)
    }

    private fun launchOrPopFragment() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MutableFragment(), "")
                .addToBackStack("mutableFragment")
                .commit()
        } else {
            supportFragmentManager.popBackStack()
        }

        supportFragmentManager.addOnBackStackChangedListener {
            setFragmentControlButtonText()
        }
    }
    private fun setFragmentControlButtonText() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            btnControlFragment.text = "Add Fragment"
        } else {
            btnControlFragment.text = "Remove Fragment"
        }
    }
}