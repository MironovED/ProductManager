package ru.netology.domain.manager;

import ru.netology.domain.Product;
import ru.netology.domain.repository.Repository;

public class ProductManager {
    private Repository repository;


    public ProductManager(Repository repository) {
        this.repository = repository;
    }


    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

}
