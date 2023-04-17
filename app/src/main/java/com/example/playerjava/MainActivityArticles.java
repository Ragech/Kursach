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

    }
}