package repository.impl;

import entity.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("001", "Iphone 13", 1200, "Iphone 13", "Apple"));
        productList.add(new Product("002", "Rog Phone 3", 1500, "Rog Phone 3", "Asus"));
        productList.add(new Product("003", "Mi 9T Pro", 1300, "Mi 9T Pro", "Xiaomi"));
        productList.add(new Product("004", "Mi Mix 3", 1400, "Mi Mix 3", "Xiaomi"));
        productList.add(new Product("005", "Samsung Z Flip", 1100, "Samsung Z Flip", "Samsung"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(String id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> findList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name)) {
                findList.add(productList.get(i));
            }
        }
        return findList;
    }

    @Override
    public void update(String id, String name, double price, String description, String producer) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                product.setName(name);
                product.setPrice(price);
                product.setDescription(description);
                product.setProducer(producer);
            }
        }
    }

    @Override
    public void remove(String id) {
        productList.removeIf(product -> product.getId().equals(id));
    }
}
