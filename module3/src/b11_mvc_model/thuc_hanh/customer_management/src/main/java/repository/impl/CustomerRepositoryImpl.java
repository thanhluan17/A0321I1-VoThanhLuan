package repository.impl;

import entity.Customer;
import repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customers.add(new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customers.add(new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customers.add(new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customers.add(new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.add(new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void update(int id, String name, String email, String address) {
        for (Customer customer : customers) {
            if (customer.getId() == (id)) {
                customer.setName(name);
                customer.setEmail(email);
                customer.setAddress(address);
            }
        }
    }

    @Override
    public void remove(int id) {
        customers.removeIf(customer -> customer.getId() == (id));
    }
}
