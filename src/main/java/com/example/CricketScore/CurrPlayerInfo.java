package com.example.CricketScore;

public class CurrPlayerInfo {
    String name;
    int score;
    int balls;
    String isOut;

    public CurrPlayerInfo(){

    }
    public CurrPlayerInfo(String name, int score, int balls,String isOut) {
        this.name = name;
        this.score = score;
        this.balls = balls;
        this.isOut = isOut;
    }

    public String getisOut() {
        return isOut;
    }

    public void setisOut(String isOut) {
        this.isOut = isOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }
}
