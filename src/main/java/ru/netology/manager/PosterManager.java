package ru.netology.manager;

import ru.netology.domain.Movie;

public class PosterManager {
    private Movie[] movies = new Movie[0];
    private int limit;

    public PosterManager() {
        limit = 10;
    }

    public PosterManager(int limit) {
        this.limit = limit;
    }

    public void addMovie(Movie movie) {
        int limit = movies.length + 1;
        Movie[] tmp = new Movie[limit];

        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        tmp[tmp.length - 1] = movie;

        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        int resultLength;
        if (movies.length > limit) {
            resultLength = limit;
        } else {
            resultLength = movies.length;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - 1 - i;
            result[i] = movies[index];
        }
        return result;
    }

    public void addAll(Movie[] newMovies) {
        int totalLength = movies.length + newMovies.length;
        Movie[] tmp = new Movie[totalLength];

        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        for (int i = 0; i < newMovies.length; i++) {
            tmp[movies.length + i] = newMovies[i];
        }

        movies = tmp;
    }
}
