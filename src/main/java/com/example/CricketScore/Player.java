package com.example.CricketScore;

public class Player {

    String name;
    int score;
    int balls;
    boolean out;
    String typeOfWicket;

    public Player() {
    }

    public Player(String name, int score, int balls, boolean out, String typeOfWicket) {
        this.name = name;
        this.score = score;
        this.balls = balls;
        this.out = out;
        this.typeOfWicket = typeOfWicket;
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

    public boolean isOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public String getTypeOfWicket() {
        return typeOfWicket;
    }

    public void setTypeOfWicket(String typeOfWicket) {
        this.typeOfWicket = typeOfWicket;
    }
}
