package model.service.customer;

import model.bean.customer.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    Map<String, String> create(Customer customer);

    Map<String, String> edit(Customer customer);

    void delete(int id);

    List<Customer> findByContainName(String key);
}
