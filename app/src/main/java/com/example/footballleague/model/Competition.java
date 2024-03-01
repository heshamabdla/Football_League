package com.example.footballleague.model;

import androidx.room.Entity;

import java.util.ArrayList;
@Entity(tableName = "competition_table")
public class Competition {
    private int id;
    private int idArea;
    private String nameArea;
    private String codeArea;
    private String flagArea;

    private String name;
    private String code;
    private String type;
    private String emblem;
    private String plan;

    public Competition() {
    }

    private int idCurrentSeason ;
    private String startDateCurrentSeason;
    private String endDateDateCurrentSeason;
    private String currentMatchdayCurrentSeason;

    private String winnerCurrentSeason;
    private int numberOfAvailableSeasons;
    private String lastUpdated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNameArea() {
        return nameArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }

    public String getCodeArea() {
        return codeArea;
    }

    public void setCodeArea(String codeArea) {
        this.codeArea = codeArea;
    }

    public String getFlagArea() {
        return flagArea;
    }

    public void setFlagArea(String flagArea) {
        this.flagArea = flagArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getIdCurrentSeason() {
        return idCurrentSeason;
    }

    public void setIdCurrentSeason(int idCurrentSeason) {
        this.idCurrentSeason = idCurrentSeason;
    }

    public String getStartDateCurrentSeason() {
        return startDateCurrentSeason;
    }

    public void setStartDateCurrentSeason(String startDateCurrentSeason) {
        this.startDateCurrentSeason = startDateCurrentSeason;
    }

    public String getEndDateDateCurrentSeason() {
        return endDateDateCurrentSeason;
    }

    public void setEndDateDateCurrentSeason(String endDateDateCurrentSeason) {
        this.endDateDateCurrentSeason = endDateDateCurrentSeason;
    }

    public String getCurrentMatchdayCurrentSeason() {
        return currentMatchdayCurrentSeason;
    }

    public void setCurrentMatchdayCurrentSeason(String currentMatchdayCurrentSeason) {
        this.currentMatchdayCurrentSeason = currentMatchdayCurrentSeason;
    }

    public String getWinnerCurrentSeason() {
        return winnerCurrentSeason;
    }

    public void setWinnerCurrentSeason(String winnerCurrentSeason) {
        this.winnerCurrentSeason = winnerCurrentSeason;
    }

    public int getNumberOfAvailableSeasons() {
        return numberOfAvailableSeasons;
    }

    public void setNumberOfAvailableSeasons(int numberOfAvailableSeasons) {
        this.numberOfAvailableSeasons = numberOfAvailableSeasons;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Competition(int id, int idArea, String nameArea, String codeArea, String flagArea, String name, String code, String type, String emblem, String plan, int idCurrentSeason, String startDateCurrentSeason, String endDateDateCurrentSeason, String currentMatchdayCurrentSeason, String winnerCurrentSeason, int numberOfAvailableSeasons, String lastUpdated) {
        this.id = id;
        this.idArea = idArea;
        this.nameArea = nameArea;
        this.codeArea = codeArea;
        this.flagArea = flagArea;
        this.name = name;
        this.code = code;
        this.type = type;
        this.emblem = emblem;
        this.plan = plan;
        this.idCurrentSeason = idCurrentSeason;
        this.startDateCurrentSeason = startDateCurrentSeason;
        this.endDateDateCurrentSeason = endDateDateCurrentSeason;
        this.currentMatchdayCurrentSeason = currentMatchdayCurrentSeason;
        this.winnerCurrentSeason = winnerCurrentSeason;
        this.numberOfAvailableSeasons = numberOfAvailableSeasons;
        this.lastUpdated = lastUpdated;
    }
}
