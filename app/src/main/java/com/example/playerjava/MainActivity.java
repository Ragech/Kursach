package com.example.playerjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.playerjava.R;
import com.example.playerjava.screens.main.MainActivityNotes;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer = null;
    ImageButton playButton, pauseButton, stopButton, nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityNotes.class);
                MainActivity.this.startActivity(intent);
            }
        });
        Button button1 = findViewById(R.id.alarm_buton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityAlarm.class);
                MainActivity.this.startActivity(intent);
            }
        });

        chooseSong(); // первый трек при запуске
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                nextPlay();
            }
        });
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.stopButton);
        nextButton = findViewById(R.id.nextButton);

        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
        nextButton.setEnabled(false);
    }

    private void chooseSong() {
        double r = Math.random() * 2;
        int rr = (int) Math.round(r);
        switch (rr) {
            case 0: mPlayer = MediaPlayer.create(this, R.raw.first); break;
            case 1: mPlayer = MediaPlayer.create(this, R.raw.second); break;
            case 2: mPlayer = MediaPlayer.create(this, R.raw.third); break;
        }
    }
    private void stopPlay(){
        mPlayer.stop();
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
        nextButton.setEnabled(false);
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
            playButton.setEnabled(true);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void playFun(){
        mPlayer.start();
        playButton.setEnabled(false);
        pauseButton.setEnabled(true);
        stopButton.setEnabled(true);
        nextButton.setEnabled(true);
    }
    public void play(View view){
        playFun();
    }

    private void nextPlay(){
        mPlayer.stop();
        chooseSong();
        mPlayer.start();
        pauseButton.setEnabled(true);
    }

    public void next(View view){
        nextPlay();
    }

    public void pause(View view){

        mPlayer.pause();
        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(true);
        nextButton.setEnabled(true);
    }
    public void stop(View view){
        stopPlay();
        chooseSong();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
    }
}