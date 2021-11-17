package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone X", 200, "Red"));
        products.put(2, new Product(2, "Mi9T", 100, "White"));
        products.put(3, new Product(3, "Rog Phone 3", 190, "Yellow"));
        products.put(4, new Product(4, "Samsung S20", 180, "Black"));
        products.put(4, new Product(5, "OnePlus 7", 150, "Gray"));
        products.put(4, new Product(6, "K20 pro", 140, "Blue"));
    }

    @Override
    public List findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}