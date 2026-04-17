package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.PosterManager;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.mockito.Mockito.*;

class PosterManagerTest {
    private AfishaRepository repo = Mockito.mock(AfishaRepository.class);

    @Test
    public void lessThenLimit() {
        PosterManager manager = new PosterManager(repo);
        Movie movie1 = new Movie("Бладшот", "боевик", "2020", 1);
        Movie movie2 = new Movie("Вперед", "мультфильм", "2020", 2);

        Movie[] returned = {movie1, movie2};
        when(repo.findAll()).thenReturn(returned);

        Movie[] expected = {movie2, movie1};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void overLimit() {
        PosterManager manager = new PosterManager(repo);
        Movie[] movies = new Movie[11];
        for (int i = 0; i < 11; i++) {
            movies[i] = new Movie("Фильм " + i, "жанр", "2024", i);
        }

        when(repo.findAll()).thenReturn(movies);

        Movie[] expected = {movies[10], movies[9], movies[8], movies[7], movies[6], movies[5], movies[4], movies[3], movies[2], movies[1]};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void customLimit() {
        PosterManager manager = new PosterManager(repo, 5);

        Movie movie1 = new Movie("Ф1", "ж", "20", 1);
        Movie movie2 = new Movie("Ф2", "ж", "20", 2);
        Movie movie3 = new Movie("Ф3", "ж", "20", 3);
        Movie movie4 = new Movie("Ф4", "ж", "20", 4);
        Movie movie5 = new Movie("Ф5", "ж", "20", 5);
        Movie movie6 = new Movie("Ф6", "ж", "20", 6);

        Movie[] returned = {movie1, movie2, movie3, movie4, movie5, movie6};
        when(repo.findAll()).thenReturn(returned);

        Movie[] expected = {movie6, movie5, movie4, movie3, movie2};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovie() {
        PosterManager manager = new PosterManager(repo);
        Movie movie1 = new Movie("Бладшот", "боевик", "2020", 1);

        manager.add(movie1);

        verify(repo).save(movie1);
    }
}