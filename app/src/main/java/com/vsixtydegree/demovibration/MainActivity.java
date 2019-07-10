package com.vsixtydegree.demovibration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btVibrate;
    Vibrator vibrate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btVibrate = findViewById(R.id.btVibrate);

        vibrate = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        btVibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrate.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    vibrate.vibrate(500);
                }


            }
        });


    }
}
