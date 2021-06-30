package com.nipun.intentservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nipun.intentservice.BoundService.MyBinder
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    var mBoundService: BoundService? = null
    var mServiceBound = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind.setOnClickListener { view ->
            val intent = Intent(applicationContext, BoundService::class.java)
            bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE)
            Log.d("Nipun", "Bind")
            Toast.makeText(this, "Service is bind", Toast.LENGTH_SHORT).show()

        }
        stop_service.setOnClickListener { view ->
            if (mServiceBound) {
                unbindService(mServiceConnection);
                mServiceBound = false;
                Log.d("Nipun", "UnBind")
                Toast.makeText(this, "Service is Unbind", Toast.LENGTH_SHORT).show()
            }


        }
        print_Detail.setOnClickListener { view ->
            if (mServiceBound) {
                getName.setText(mBoundService?.getName())
                getAge.setText(mBoundService?.getAge())
                getAddress.setText(mBoundService?.getAddress())
                Log.d("Nipun", "PrintDetail")
                Toast.makeText(this, "Printing Detail", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Please Bind your service first", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private val mServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName) {
            mServiceBound = false
        }

        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            val myBinder = service as MyBinder
            mBoundService = myBinder.service
            mServiceBound = true
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        if (mServiceBound) {
            unbindService(mServiceConnection)
            mServiceBound = false
        }
    }
}