package com.nipun.secondevaluation.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nipun.secondevaluation.FragmentCommunicationListener
import com.nipun.secondevaluation.R
import com.nipun.secondevaluation.SecondActivity
import com.nipun.secondevaluation.ThirdActivity
import kotlinx.android.synthetic.main.fragment_banana.*


class BananaFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_banana, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var total: Int = 0
        btnNext.setOnClickListener {
            val intent = Intent(activity, ThirdActivity::class.java)
            intent.putExtra("Banana", etTotalBanana.text.toString().toInt())
//            intent.putExtra("perBanana", etPricePerBanana.text.toString().toInt())
//            intent.putExtra("discount", etdiscountPerBanana.text.toString().toInt())
            intent.putExtra("total1", total)
            startActivity(intent)
        }
        btnTotalPrice.setOnClickListener {
            val Banana = etTotalBanana.text.toString().toInt()
            val perBanana = etPricePerBanana.text.toString().toInt()
            val discountBanana = etdiscountPerBanana.text.toString().toInt()
            val discountPrice = (Banana * perBanana * discountBanana) / 100
            total = ((Banana * perBanana) - discountPrice)
            tvTotal.text = total.toString()
        }
    }

    fun setListener(listener: FragmentCommunicationListener) {
        this.listener = listener
    }
}