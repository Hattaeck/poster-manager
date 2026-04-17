package ru.netology;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class PosterManager {
    private AfishaRepository repository;
    private int limit = 10;

    public PosterManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public PosterManager(AfishaRepository repository, int limit) {
        this.repository = repository;
        this.limit = limit;
    }

    public void add(Movie item) {
        repository.save(item);
    }

    public Movie[] findAll() {
        return repository.findAll();
    }

    public Movie[] findLast() {
        Movie[] all = repository.findAll();
        int resultLength = Math.min(all.length, limit);
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = all[all.length - 1 - i];
        }
        return result;
    }
}