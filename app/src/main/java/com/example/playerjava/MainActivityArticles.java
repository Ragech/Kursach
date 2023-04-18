package com.example.playerjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityArticles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        Button articl1_but = findViewById(R.id.articl1);
        articl1_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.article_one);
            }
        });
        Button articl2_but = findViewById(R.id.articl2);
        articl2_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.article_two);
            }
        });
        Button articl3_but = findViewById(R.id.articl3);
        articl3_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.article_three);
            }
        });

        Button articl4_but = findViewById(R.id.articl4);
        articl4_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.article_four);
            }
        });

        Button articl5_but = findViewById(R.id.articl5);
        articl5_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.article_five);
            }
        });

        Button articl6_but = findViewById(R.id.articl6);
        articl6_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.article_six);
            }
        });

        Button articl7_but = findViewById(R.id.articl7);
        articl7_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.article_seven);
            }
        });

        Button articl8_but = findViewById(R.id.articl8);
        articl8_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.article_eight);
            }
        });

        Button articl9_but = findViewById(R.id.articl9);
        articl9_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.article_nine);
            }
        });

        Button articl10_but = findViewById(R.id.articl10);
        articl10_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.article_ten);
            }
        });

    }
}