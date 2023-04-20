package com.example.playerjava;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "fastMessage")
    public String fastMessage;

    public Word(String fastMessage) {
        this.fastMessage = fastMessage;
    }
}
