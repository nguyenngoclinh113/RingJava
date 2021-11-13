package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Button RingButton, VibrateButton;


    public void OpenDialog(View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.layout_studio, null);


        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.iphone);
        final Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        RingButton = (Button) mView.findViewById(R.id.RingButton);
        VibrateButton = (Button) mView.findViewById(R.id.VibrateButton);

        alert.setView(mView);

        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);

        RingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        VibrateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                {
                    vibrator.vibrate(VibrationEffect.createOneShot(200,VibrationEffect.DEFAULT_AMPLITUDE));
                }
                else
                {
                    vibrator.vibrate(200);
                }
            }
        });
        alertDialog.show();
    }

}