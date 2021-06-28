package com.nipun.secondevaluation.Fragment

import android.content.Intent
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import com.nipun.secondevaluation.FragmentCommunicationListener
import com.nipun.secondevaluation.R
import com.nipun.secondevaluation.SecondActivity
import kotlinx.android.synthetic.main.fragment_apple.*


class AppleFragment : Fragment() {

    private var listener: FragmentCommunicationListener? = null
    // TODO: Rename and change types of parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apple, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var total: Int = 0
        btnNext.setOnClickListener {
            val intent = Intent(activity, SecondActivity::class.java)
           intent.putExtra("apple", etTotalApple.text.toString().toInt())
//            intent.putExtra("perApple", etPricePerApple.text.toString().toInt())
//            intent.putExtra("discount", etdiscountPerApple.text.toString().toInt())
            intent.putExtra("total1", total)
            startActivity(intent)
        }
        btnTotalPrice.setOnClickListener {
            val apple = etTotalApple.text.toString().toInt()
            val perApple = etPricePerApple.text.toString().toInt()
            val discountApple = etdiscountPerApple.text.toString().toInt()
            val discountPrice = (apple * perApple * discountApple) / 100
            total = ((apple * perApple) - discountPrice)
            tvTotal.text = total.toString()
        }
    }
    fun setListener(listener: FragmentCommunicationListener) {
        this.listener = listener
    }
}