package com.example.playerjava;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.playerjava.screens.main.MainActivityNotes;

import java.util.Random;

public class AlarmActivity extends AppCompatActivity {
    TextView num1,num2;
    int randnum1,randnum2;

    EditText edit_answer;
    Ringtone ringtone;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Uri notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        ringtone = RingtoneManager.getRingtone(this, notificationUri);
        if (ringtone == null) {
            notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            ringtone = RingtoneManager.getRingtone(this, notificationUri);
        }
        if (ringtone != null) {
            ringtone.play();
            long[] pattern = { 500, 300, 400, 200 };
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (vibrator.hasVibrator()) {
                vibrator.vibrate(pattern, 2);
            }
        }
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        edit_answer = findViewById(R.id.answer);

        Random random = new Random();
        randnum1 = random.nextInt(10)+1;
        Log.d(TAG, String.valueOf(randnum1));
        randnum2 = random.nextInt(10)+1;
        Log.d(TAG, String.valueOf(randnum2));
        num1.setText(String.valueOf(randnum1));
        num2.setText(String.valueOf(randnum2));

        Toast toast1 = Toast.makeText(this, "Введите пожалуйста ответ", Toast.LENGTH_SHORT);
        Toast toast2 = Toast.makeText(this, "Ваш ответ не верный, попробуйте еще раз", Toast.LENGTH_SHORT);


        Button button = findViewById(R.id.button_off);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_answer.getText().toString().isEmpty() ){
                    toast1.show();
                }
                else {
                    int num = Integer.parseInt(edit_answer.getText().toString());
                    if (randnum1 + randnum2 == num) {
                        Intent intent = new Intent(AlarmActivity.this, MainActivity.class);
                        AlarmActivity.this.startActivity(intent);
                        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        vibrator.cancel();
                        ringtone.stop();
                    } else {
                        toast2.show();
                    }
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        // ваш код
    }
    @Override
    protected void onUserLeaveHint() {

    }

    @Override
    protected void onDestroy() {
        if (ringtone != null && ringtone.isPlaying()) {
            ringtone.stop();
        }
        super.onDestroy();
    }
}