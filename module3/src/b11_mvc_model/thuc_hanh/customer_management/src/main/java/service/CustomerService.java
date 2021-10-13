package service;

import entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, String name, String email, String address);

    void remove(int id);
}
