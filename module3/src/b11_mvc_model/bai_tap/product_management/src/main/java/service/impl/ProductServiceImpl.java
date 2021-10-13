package service.impl;

import entity.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void update(String id, String name, double price, String description, String producer) {
        productRepository.update(id, name, price, description, producer);
    }

    @Override
    public void remove(String id) {
        productRepository.remove(id);
    }
}
