package com.codegym.cart.service;

import com.codegym.cart.model.Product;

public interface ProductService {
    Iterable<Product> findAll();

    Product findById(Integer id);
}
