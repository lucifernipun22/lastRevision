package com.nipun.secondevaluation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val total1 = intent.getIntExtra("total1", 0)
        val total2 = intent.getIntExtra("total2", 0)
        val apple = intent.getStringExtra("apple")
        val banana = intent.getStringExtra("Banana")
        val total = total1 + total2
        val text = findViewById<TextView>(R.id.texttt)
        text.text = total.toString()
        val appletv = findViewById<TextView>(R.id.aaple)
        val banantv = findViewById<TextView>(R.id.banana)
        appletv.text = apple
        banantv.text = banana

    }

}