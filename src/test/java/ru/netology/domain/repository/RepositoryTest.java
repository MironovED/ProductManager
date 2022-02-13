package ru.netology.domain.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    private Repository repo = new Repository();
    private Product TShirt = new Product( 1, "Футболка", 101);
    private Book HarryPotter = new Book( 12, "Гарри Потер", 211, "Дж. Роулинг");
    private Smartphone IphoneX = new Smartphone(32, "IphoneX", 500 , "Apple");

    @Test
    void add3Product() {
        repo.save(TShirt);
        repo.save(HarryPotter);
        repo.save(IphoneX);

        Product[] actual = repo.findAll();
        Product[] expected = {TShirt, HarryPotter, IphoneX};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add2Product() {
        Repository repo = new Repository();
        repo.save(TShirt);
        repo.save(HarryPotter);

        Product[] actual = repo.findAll();
        Product[] expected = {TShirt, HarryPotter};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add1Product() {
        repo.save(IphoneX);

        Product[] actual = repo.findAll();
        Product[] expected = {IphoneX};

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        Product[] actual = repo.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }


    @Test
    void removeById() {
        repo.save(TShirt);
        repo.save(HarryPotter);
        repo.save(IphoneX);

        repo.removeById(12);

        Product[] actual = repo.findAll();
        Product[] expected = {TShirt, IphoneX};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdAll() {
        repo.save(TShirt);
        repo.save(HarryPotter);
        repo.save(IphoneX);

        repo.removeById(12);
        repo.removeById(32);
        repo.removeById(1);

        Product[] actual = repo.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    @Disabled
    void shouldNotRemoveIfNotExists() {
        repo.save(TShirt);
        repo.save(HarryPotter);
        repo.save(IphoneX);

        repo.removeById(3);

        Product[] actual = repo.findAll();
        Product[] expected = {TShirt, HarryPotter, IphoneX};

        assertArrayEquals(expected, actual);
    }

}
