package com.example.footballleague.model;

import java.util.ArrayList;

public class CompetitionResponse {
    private int count;
    private ArrayList<String> filters;
    private ArrayList<Competition> competitions;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<String> getFilters() {
        return filters;
    }

    public void setFilters(ArrayList<String> filters) {
        this.filters = filters;
    }

    public ArrayList<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(ArrayList<Competition> competitions) {
        this.competitions = competitions;
    }

    public CompetitionResponse(int count, ArrayList<String> filters, ArrayList<Competition> competitions) {
        this.count = count;
        this.filters = filters;
        this.competitions = competitions;
    }
}
