package service.impl;

import entity.Customer;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(int id, String name, String email, String address) {
        customerRepository.update(id, name, email, address);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}
