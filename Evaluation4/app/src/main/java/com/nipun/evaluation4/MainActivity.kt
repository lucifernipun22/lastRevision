package com.nipun.evaluation4

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.*
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import java.io.DataInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL


class MainActivity : AppCompatActivity() {
    val u = URL("http://pages.cs.wisc.edu/~navin/india/songs/isongs/indexes/icons/blank_jtrans.gif")
    var mBoundService: BoundService? = null
    var mServiceBound = false
    var networkReceiver : NetworkReceiver? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bind = findViewById<Button>(R.id.bind)
        val editText = findViewById<EditText>(R.id.editText)
        val tvText = findViewById<TextView>(R.id.tvText)
        val print = findViewById<Button>(R.id.print)
        val intent = Intent(applicationContext, BoundService::class.java)
        bind.setOnClickListener { view ->
            if (editText.length() != 0) {

                intent.putExtra("data",editText.text.toString())
                bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE)
                Log.d("Nipun", "bind")
                Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()
                DownloadFile()

                Toast.makeText(this, "Donwload start", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Type Correct url", Toast.LENGTH_SHORT).show()

            }
        }
        print.setOnClickListener { view->
            if(intent != null){
                var data = intent.getStringExtra("data")
                tvText.setText(data)

            }
        }

    }

    private val mServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val myBinder = service as BoundService.MyBinder
            mBoundService = myBinder.service
            mServiceBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {

            mServiceBound = false
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    fun DownloadFile() {
        try {

            val `is` = u.openStream()
            val dataInputStream = DataInputStream(`is`)
            val buffer = ByteArray(1024)
            var length: Int
            val fileOutputStream = FileOutputStream(
                File(
                    Environment.getExternalStorageDirectory().toString() + "/" + "Download"
                )
            )
            while (dataInputStream.read(buffer).also { length = it } > 0) {
                fileOutputStream.write(buffer, 0, length)
                Toast.makeText(this, "Donwload start", Toast.LENGTH_SHORT).show()
            }

        } catch (malformedURLException: MalformedURLException) {
            Log.e("getUpdate", "url error", malformedURLException)
        } catch (ioe: IOException) {
            Log.e("getUpdate1", "url error", ioe)
        } catch (se: SecurityException) {
            Log.e("getUpdate2", "url error", se)
        }
    }
    public class NetworkReceiver: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val intent : Intent


        }
    }


}