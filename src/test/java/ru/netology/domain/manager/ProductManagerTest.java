package ru.netology.domain.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
        private Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        private Product TShirt = new Product( 1, "TShirt", 101);
        private Book HarryPotter = new Book( 12, "HarryPotter", 211, "Дж. Роулинг");
        private Smartphone IphoneX = new Smartphone(32, "IphoneX", 500 , "Apple");

    @Test
    void add3Product() {
        manager.add(TShirt);
        manager.add(HarryPotter);
        manager.add(IphoneX);

        Product[] actual = repo.findAll();
        Product[] expected = { TShirt, HarryPotter, IphoneX };

        assertArrayEquals(expected, actual);
    }

    @Test
    void add2Product() {
        manager.add(TShirt);
        manager.add(HarryPotter);

        Product[] actual = repo.findAll();
        Product[] expected = { TShirt, HarryPotter };

        assertArrayEquals(expected, actual);
    }

    @Test
    void add1Product() {
        manager.add(HarryPotter);

        Product[] actual = repo.findAll();
        Product[] expected = { HarryPotter };

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy() {
        manager.add(TShirt);
        manager.add(HarryPotter);
        manager.add(IphoneX);

        Product[] actual = manager.searchBy("IphoneX");
        Product[] expected = {IphoneX};

        assertEquals( expected, actual);
    }

}