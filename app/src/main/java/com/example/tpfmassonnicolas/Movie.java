package com.example.tpfmassonnicolas;

import java.io.Serializable;

public class Movie implements Serializable {
    private String name;
    private String type;
    private int year;
    private int movieRating;
    private String movieDescription;

    //Method to create the constructor the object Movie
    public Movie(String name, String type, int year, int movieRating, String movieDescription) {
        this.name = name;
        this.type = type;
        this.year = year;
        this.movieRating = movieRating;
        this.movieDescription = movieDescription;
    }

    //Method for obtaining data from the movie object

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", movieRating=" + movieRating +
                ", movieDescription='" + movieDescription + '\'' +
                '}';
    }
}
