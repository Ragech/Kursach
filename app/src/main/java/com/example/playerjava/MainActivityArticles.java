package com.example.playerjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.playerjava.articles.Articl1;
import com.example.playerjava.articles.Articl10;
import com.example.playerjava.articles.Articl2;
import com.example.playerjava.articles.Articl3;
import com.example.playerjava.articles.Articl4;
import com.example.playerjava.articles.Articl5;
import com.example.playerjava.articles.Articl6;
import com.example.playerjava.articles.Articl7;
import com.example.playerjava.articles.Articl8;
import com.example.playerjava.articles.Articl9;
import com.example.playerjava.screens.main.MainActivityNotes;


public class MainActivityArticles extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        Button articl1_but = findViewById(R.id.articl1);
        articl1_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityArticles.this, Articl1.class);
                MainActivityArticles.this.startActivity(intent);
            }
        });
        Button articl2_but = findViewById(R.id.articl2);
        articl2_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityArticles.this, Articl2.class);
                MainActivityArticles.this.startActivity(intent);
            }
        });
        Button articl3_but = findViewById(R.id.articl3);
        articl3_but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityArticles.this, Articl3.class);
                MainActivityArticles.this.startActivity(intent);
            }
        });

        Button articl4_but = findViewById(R.id.articl4);
        articl4_but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityArticles.this, Articl4.class);
                MainActivityArticles.this.startActivity(intent);
            }
        });

        Button articl5_but = findViewById(R.id.articl5);
        articl5_but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityArticles.this, Articl5.class);
                MainActivityArticles.this.startActivity(intent);
            }
        });

        Button articl6_but = findViewById(R.id.articl6);
        articl6_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityArticles.this, Articl6.class);
                MainActivityArticles.this.startActivity(intent);
            }
        });

        Button articl7_but = findViewById(R.id.articl7);
        articl7_but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityArticles.this, Articl7.class);
                MainActivityArticles.this.startActivity(intent);
            }
        });

        Button articl8_but = findViewById(R.id.articl8);
        articl8_but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityArticles.this, Articl8.class);
                MainActivityArticles.this.startActivity(intent);
            }
        });

        Button articl9_but = findViewById(R.id.articl9);
        articl9_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityArticles.this, Articl9.class);
                MainActivityArticles.this.startActivity(intent);
            }
        });

        Button articl10_but = findViewById(R.id.articl10);
        articl10_but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityArticles.this, Articl10.class);
                MainActivityArticles.this.startActivity(intent);
            }
        });
    }

}