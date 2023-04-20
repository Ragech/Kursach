package com.example.playerjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public List<Word> wordList;
    private TextView WordView;
    Timer myTimer = new Timer();
    private TimerTask MyTimerTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WordView = findViewById(R.id.WordView);
        WordDatabase db = Room.databaseBuilder(getApplicationContext(),
                WordDatabase.class, "word-database").allowMainThreadQueries().build();
        //Word a = new Word("Откажитесь от алкоголя. Он делает сон поверхностным, беспокойным, а также способствует появлению храпа."); // Слово для базы данных

        //db.wordDao().insertAll(a); //Добавление слов в Базу данных
        //db.wordDao().deleteAllWords(); //Удаление всех элементов базы данных
        wordList=db.wordDao().getAllWords();
        getWord();

    }
    private void getWord() {
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (final Word list : wordList) {
                    final String wrd = list.fastMessage;
                    final double rnd = Math.random() * 12;
                    final int id = (int) Math.round(rnd);
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
}