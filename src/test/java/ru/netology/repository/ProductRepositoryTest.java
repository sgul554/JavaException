package ru.netology.repository;

import ru.netology.domain.Product;
import  org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
    Product first = new Product(123456, "first", 210);
    Product second = new Product(987654, "second", 5000);
    Product third = new Product(543678, "third", 432);

    @Test
    public void shouldRemoveByIdNotFound() {
        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
        assertThrows(NotFoundException.class, () -> {
            repo.removeById(123);
        });

    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeById(543678);
    }

}