package com.nipun.extension

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nipun.extension.model.dataX
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback;
import retrofit2.Response


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener { view->
            fetchUsersData()
        }
        email.setOnClickListener { view->
            view.showKeyboard()
        }
        password.setOnClickListener{ view->
            view.showKeyboard()
        }

    }

    private fun fetchUsersData() {
        val email = ""
        val password = ""
        val apiService: RepositoryApiService = RepositoryApiMaker().getService()
        val userListCall: Call<dataX> = apiService.setRepositoryList(email,password)
        userListCall.enqueue(object : Callback<dataX?> {
            override fun onResponse(call: Call<dataX?>?, response: Response<dataX?>) {
                if (response.body() != null) {
                    val updateadata: dataX = response.body()!!
                    updateData(updateadata);

                    Toast.makeText(this@RegisterActivity, "succesfull", Toast.LENGTH_SHORT ).show()

                } else {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Request not Sucessful",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<dataX?>?, t: Throwable?) {
                Toast.makeText(
                    this@RegisterActivity,
                    "Request failed. Check your internet connection",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
    fun updateData(responseModelList: dataX) {
        tvId.text = responseModelList.email
        tvToken.text = responseModelList.password
    }
}