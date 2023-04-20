package com.example.playerjava;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insertAll(Word... words);

    @Query("DELETE FROM word")
    void deleteAllWords();

    @Query("SELECT * FROM word")
    List<Word> getAllWords();
}
