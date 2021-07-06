package com.nipun.thread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mBtnStart1;
    private Button mBtnStart2;
    private LottieAnimationView p1;
    private LottieAnimationView p2;
    private BackGroundTask looperThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStart1 = findViewById(R.id.btn1);
        mBtnStart2 = findViewById(R.id.btn2);
        p1 = findViewById(R.id.bar1);
        p2 = findViewById(R.id.bar2);
        looperThread = new BackGroundTask();

        mBtnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    Log.d("Nipun", i + "");
                    SystemClock.sleep(1000);
                }
                Toast.makeText(MainActivity.this, "Handler 1 start", Toast.LENGTH_SHORT).show();

                Thread thread = new Thread();
                thread.start();
                Toast.makeText(MainActivity.this, "Handler 1 end", Toast.LENGTH_SHORT).show();
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.GONE);
            }
        });

        mBtnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    Log.d("Nipun", i + "");
                    SystemClock.sleep(1000);
                }
                looperThread.start();
                Toast.makeText(MainActivity.this, "Handler 2 end", Toast.LENGTH_SHORT).show();
                p2.setVisibility(View.VISIBLE);
                p1.setVisibility(View.GONE);
            }
        });

    }
}