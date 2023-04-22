package com.example.playerjava;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.playerjava.data.WordDatabase;
import com.example.playerjava.model.Word;
import com.example.playerjava.screens.main.MainActivityNotes;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    public List<Word> wordList;
    private TextView WordView;
    private WordDatabase db;
    Timer myTimer = new Timer();
    MediaPlayer mPlayer = null;
    Button setAlarm;
    ImageButton playButton, pauseButton, stopButton, nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());

        WordView = findViewById(R.id.WordView);
        db = Room.databaseBuilder(getApplicationContext(),
                        WordDatabase.class, "wordDatabase")
                .createFromAsset("word-database.db").allowMainThreadQueries()
                .build();

        //Word a = new Word("123"); // Слово для базы данных
        //db.wordDao().insertAll(a); //Добавление слов в Базу данных
        //db.wordDao().deleteAllExtraWords(); //Удаление всех элементов базы данных после 12

        wordList = db.wordDao().getAllWords();
        getWord();


        setAlarm = findViewById(R.id.alarm_button);

        setAlarm.setOnClickListener(v -> {
            MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_24H)
                    .setHour(12)
                    .setMinute(0)
                    .setTitleText("Выберите время для будильника")
                    .build();

            materialTimePicker.addOnPositiveButtonClickListener(view -> {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.MINUTE, materialTimePicker.getMinute());
                calendar.set(Calendar.HOUR_OF_DAY, materialTimePicker.getHour());
                if (calendar.getTimeInMillis() < System.currentTimeMillis()) {
                    calendar.add(Calendar.DATE, 1);
                }

                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                AlarmManager.AlarmClockInfo alarmClockInfo = new AlarmManager.AlarmClockInfo(calendar.getTimeInMillis(), getAlarmInfoPendingIntent());

                alarmManager.setAlarmClock(alarmClockInfo, getAlarmActionPendingIntent());
                Toast.makeText(this, "Будильник установлен на " + sdf.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
            });

            materialTimePicker.show(getSupportFragmentManager(), "tag_picker");
        });

         /*Запрос разрешения на показ окон поверх других приложений
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivity(intent);
            }
        }
         */

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityNotes.class);
                MainActivity.this.startActivity(intent);
            }
        });


        Button articles = findViewById(R.id.articles);
        articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityArticles.class);
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

    private void getWord() {
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (final Word list : wordList) {
                    final String wrd = list.fastMessage;
                    final double rnd = Math.random() * 11;
                    final int id = (int) Math.round(rnd) + 1;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (id == list.uid) {
                                WordView.setText(wrd);
                            }
                        }
                    });
                }
            }
        }, 0, 5000);
    }

    private PendingIntent getAlarmInfoPendingIntent() {
        Intent alarmInfoIntent = new Intent(this, MainActivity.class);
        alarmInfoIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        return PendingIntent.getActivity(this, 0, alarmInfoIntent, PendingIntent.FLAG_IMMUTABLE);
    }

    private PendingIntent getAlarmActionPendingIntent() {
        Intent intent = new Intent(this, AlarmActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        return PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_IMMUTABLE);
    }

    private void chooseSong() {
        double r = Math.random() * 6;
        int rr = (int) Math.round(r);
        switch (rr) {
            case 0: mPlayer = MediaPlayer.create(this, R.raw.first); break;
            case 1: mPlayer = MediaPlayer.create(this, R.raw.second); break;
            case 2: mPlayer = MediaPlayer.create(this, R.raw.third); break;
            case 3: mPlayer = MediaPlayer.create(this, R.raw.fourth); break;
            case 4: mPlayer = MediaPlayer.create(this, R.raw.fifth); break;
            case 5: mPlayer = MediaPlayer.create(this, R.raw.sixth); break;
            case 6: mPlayer = MediaPlayer.create(this, R.raw.seventh); break;
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