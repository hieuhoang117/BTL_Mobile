package com.example.btlmobile;

import java.util.List;

public class CategoryResponse {
    private List<Movie> movies;
    private List<Series> series;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }
}
