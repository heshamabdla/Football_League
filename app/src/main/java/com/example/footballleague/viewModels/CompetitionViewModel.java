package com.example.footballleague.viewModels;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.footballleague.model.Competition;
import com.example.footballleague.model.CompetitionResponse;
import com.example.footballleague.repository.Repository;

import java.io.Closeable;
import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CompetitionViewModel extends ViewModel {
    private Repository repository;

    MutableLiveData <ArrayList<Competition>> competitionList=new MutableLiveData<>();
    LiveData<ArrayList<Competition>> competitionArrayList=null;

    public LiveData<ArrayList<Competition>> getCompetitionArrayList() {
        return competitionArrayList;
    }

    @ViewModelInject
    public CompetitionViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ArrayList<Competition>> getCompetitionList() {
        return competitionList;
    }

    @SuppressLint("CheckResult")
    public void getCompetition(){
        repository.getCompetition()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> competitionList.setValue(result.getCompetitions())
                        ,e-> Log.e("ViewModel Error",e.getMessage()));
    }
    public void insertCompetition(Competition competition){
        repository.insetCompetition(competition);
    }
    public void getAllCompetitions(){
      competitionArrayList= repository.getAllCompetition();
    }
}
