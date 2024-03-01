package com.example.footballleague.dp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.footballleague.model.Competition;

import java.util.ArrayList;

@Dao
public interface CompetitionDao {
    @Insert
    public  void insertCompetition(Competition competition);

    @Query("select * from competition_table")
    public LiveData<ArrayList<Competition>> getCompetitions();


}
