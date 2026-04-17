package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;




class PosterManagerTest {
    private PosterManager manager;

    @BeforeEach
    void setUp() {
        manager = new PosterManager();
    }

    @Test
    public void lessThenLimit() {
        Movie movie1 = new Movie("Бладшот", "боевик", "2020");
        Movie movie2 = new Movie("Вперед", "мультфильм", "2020");
        Movie movie3 = new Movie("Отель Белград", "комедия", "2020");
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);

        Movie[] expected = {movie3, movie2, movie1};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void overLimit() {
        Movie[] movies = new Movie[11];
        for (int i = 0; i < 11; i++) {
            movies[i] = new Movie("Фильм " + i, "жанр", "2024");
            manager.addMovie(movies[i]);
        }

        Movie[] expected = {movies[10], movies[9], movies[8], movies[7], movies[6], movies[5], movies[4], movies[3], movies[2], movies[1]};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void exactlyLimit() {
        Movie[] movies = new Movie[10];
        for (int i = 0; i < 10; i++) {
            movies[i] = new Movie("Фильм " + i, "жанр", "2024");
            manager.addMovie(movies[i]);
        }

        Movie[] expected = {movies[9], movies[8], movies[7], movies[6], movies[5], movies[4], movies[3], movies[2], movies[1], movies[0]};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void customLimit() {
        PosterManager manager = new PosterManager(5);
        Movie movie1 = new Movie("Бладшот", "боевик", "2020");
        Movie movie2 = new Movie("Вперед", "мультфильм", "2020");
        Movie movie3 = new Movie("Отель Белград", "комедия", "2020");
        Movie movie4 = new Movie("Джентельмены", "боевик", "2020");
        Movie movie5 = new Movie("Человек-невидимка", "ужасы", "2020");
        Movie movie6 = new Movie("Тролли. Мировой тур", "мультфильм", "2020");
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);

        Movie[] expected = {movie6, movie5, movie4, movie3, movie2};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSeveralMoviesWithAddAll() {
        Movie movie1 = new Movie("Бладшот", "боевик", "2020");
        Movie movie2 = new Movie("Вперед", "мультфильм", "2020");
        Movie[] moviesToAdd = {movie1, movie2};

        manager.addAll(moviesToAdd);

        Movie[] expected = {movie2, movie1};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}