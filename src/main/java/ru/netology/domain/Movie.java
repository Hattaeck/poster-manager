package ru.netology.domain;


public class Movie {
    private String name;
    private String genre;
    private String releaseDate;

    public Movie(String name, String genre, String releaseDate) {
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}