package com.tekion.movieinfoservice.models;

public class MovieSummary {
    private String title;
    private String overview;

    public MovieSummary(){}
    public MovieSummary(String title, String overview) {
        this.title = title;
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
