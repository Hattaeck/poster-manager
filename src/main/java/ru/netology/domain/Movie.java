package ru.netology.domain;


public class Movie {
    private String name;
    private String genre;
    private String releaseDate;
    private int id;

    public Movie(String name, String genre, String releaseDate, int id) {
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.id = id;
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