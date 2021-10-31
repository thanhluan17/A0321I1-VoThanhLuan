package model.repository.customer;

import model.bean.customer.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void save(Customer customer);

    void delete(int id);

    void update(Customer customer);

    Customer findById(int id);

    Customer findByName(String name);

    List<Customer> findByContainName(String key);
}
