package com.example.playerjava.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.playerjava.model.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insertAll(Word... words);

    @Query("DELETE FROM word WHERE uid > 12")
    void deleteAllExtraWords();

    @Query("SELECT * FROM word")
    List<Word> getAllWords();
}
