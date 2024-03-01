package com.example.footballleague.dp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.footballleague.model.Competition;

@Database(entities = Competition.class,version = 1,exportSchema = false)
public abstract class CompetitionDB extends RoomDatabase {
    public abstract CompetitionDao competitionDao();


}
