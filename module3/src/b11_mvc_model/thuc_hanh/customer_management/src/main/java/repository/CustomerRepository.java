package repository;

import entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, String name, String email, String address);

    void remove(int id);
}
