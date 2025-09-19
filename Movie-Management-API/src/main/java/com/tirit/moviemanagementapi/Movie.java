package com.tirit.moviemanagementapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String director;
    private int releaseYear;
    private double rating;

    public Movie(long id, String title, String director, int year, double rating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseYear = year;
        this.rating = rating;
    }

    public Movie() {

    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setReleaseYear(int year) {
        this.releaseYear = year;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
