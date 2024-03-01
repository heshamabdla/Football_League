package com.example.footballleague.api;

import com.example.footballleague.model.CompetitionResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface CompetitionApiInterface {

    @GET("competitions")
    Observable<CompetitionResponse> getCompetition();
}
