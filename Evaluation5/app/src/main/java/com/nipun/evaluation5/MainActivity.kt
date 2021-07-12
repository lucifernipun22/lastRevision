package com.nipun.evaluation5

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import java.io.IOException

class MainActivity : AppCompatActivity() , OnClickListner {

    var button: Button? = null
    var recyclerView: RecyclerView? = null
    var responseList: Response? = null
    var dataAdapter: DataAdapter? = null
    var editText: EditText? = null
    val mediaPlayer = MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        button = findViewById<Button>(R.id.btn)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        editText = findViewById<EditText>(R.id.editSearch)
        button!!.setOnClickListener { callApi() }
    }

    open fun callApi() {
        val str = editText!!.text.toString()
        val apiService = Network.getInstance().create(
            ApiService::class.java
        )
        apiService.getUser(str).enqueue(object : Callback<Response?> {
            override fun onResponse(
                call: Call<Response?>,
                response: retrofit2.Response<Response?>
            ) {
                setRecyclerView(responseList!!)
                if (response.body() != null) {
                    responseList = response.body()
                    dataAdapter!!.updateList(responseList)
                }
            }

            override fun onFailure(call: Call<Response?>, t: Throwable) {}
        })
    }

    open fun setRecyclerView(responseList: Response) {
        dataAdapter = DataAdapter(responseList, this)
        dataAdapter!!.notifyDataSetChanged()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = linearLayoutManager
        recyclerView!!.adapter = dataAdapter
    }

    override fun playMusic(pos: Int, result: Result) {
        mediaPlayer.reset()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            mediaPlayer.setDataSource(result.previewUrl)
            mediaPlayer.prepare()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        mediaPlayer.start()
    }

    override fun pauseMusic() {
        mediaPlayer.stop()
    }

    override fun delete(pos: Int) {
        /*responseList!!.results.
        dataAdapter!!.updateList(responseList)*/
    }

}