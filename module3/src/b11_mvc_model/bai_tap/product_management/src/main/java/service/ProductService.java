package service;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(String id);

    List<Product> findByName(String name);

    void update(String id, String name, double price, String description, String producer);

    void remove(String id);
}
