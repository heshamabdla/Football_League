package com.example.footballleague.di;

import android.app.Application;

import androidx.room.Room;

import com.example.footballleague.dp.CompetitionDB;
import com.example.footballleague.dp.CompetitionDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class RoomModule {

    @Provides
    @Singleton
    public static CompetitionDB provideDB(Application application){
        return Room.databaseBuilder(application,CompetitionDB.class,"competition_DB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static CompetitionDao provideDao(CompetitionDB competitionDB){
        return competitionDB.competitionDao();
    }


}
