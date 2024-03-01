package com.example.footballleague.repository;

import androidx.lifecycle.LiveData;

import com.example.footballleague.api.CompetitionApiInterface;
import com.example.footballleague.di.RetrofitModule;
import com.example.footballleague.dp.CompetitionDB;
import com.example.footballleague.dp.CompetitionDao;
import com.example.footballleague.model.Competition;
import com.example.footballleague.model.CompetitionResponse;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repository {
   private CompetitionApiInterface competitionApiInterface;
   private CompetitionDao competitionDao;

    @Inject
    public Repository(CompetitionApiInterface competitionApiInterface,CompetitionDao competitionDao) {
        this.competitionApiInterface = competitionApiInterface;
        this.competitionDao=competitionDao;
    }

    public Observable<CompetitionResponse> getCompetition(){
        return competitionApiInterface.getCompetition();
    }

    public void insetCompetition(Competition competition){
        competitionDao.insertCompetition(competition);
    }

    public LiveData<ArrayList<Competition>> getAllCompetition(){
        return competitionDao.getCompetitions();
    }
}
