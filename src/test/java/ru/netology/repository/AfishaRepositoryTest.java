package ru.netology.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

public class AfishaRepositoryTest {
    AfishaRepository repo = new AfishaRepository();

    Movie item1 = new Movie("Бладшот", "боевик", "2020", 1);
    Movie item2 = new Movie("Вперед", "мультфильм", "2020", 2);
    Movie item3 = new Movie("Отель Белград", "комедия", "2020", 3);

    @Test
    public void shouldRemoveById() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        repo.removeById(2);

        Movie[] expected = {item1, item3};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        repo.save(item1);
        repo.save(item2);

        Movie expected = item2;
        Movie actual = repo.findById(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindById() {
        repo.save(item1);

        Movie actual = repo.findById(99);

        Assertions.assertNull(actual);
    }

    @Test
    public void shouldThrowExceptionIfIdNotFound() {
        repo.save(item1);

        Assertions.assertThrows(RuntimeException.class, () -> {
            repo.removeById(99);
        });
    }
}

//комент для пул реквеста тест
