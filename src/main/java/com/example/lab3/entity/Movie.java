package com.example.lab3.entity;


public class Movie {

    private int id;
    private String name;
    private int year;
    private double rank;

    public Movie() {
    }

    public Movie(int id, String name, int year, double rank) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
}
