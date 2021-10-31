package model.service.customer.impl;

import model.bean.customer.Customer;
import model.repository.customer.CustomerRepository;
import model.repository.customer.impl.CustomerRepositoryImpl;
import model.service.common.Validator;
import model.service.customer.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Map<String, String> create(Customer customer) {
        Map<String, String> mapMessage = new HashMap<>();
        if (Validator.validateDate(customer.getBirthday()) != null
                || Validator.validateIdCard(customer.getCardID()) != null
                || Validator.validatePhone(customer.getPhone()) != null
                || Validator.validateEmail(customer.getEmail()) != null) {
            mapMessage.put("birthday", Validator.validateDate(customer.getBirthday()));
            mapMessage.put("idCard", Validator.validateIdCard(customer.getCardID()));
            mapMessage.put("phone", Validator.validatePhone(customer.getPhone()));
            mapMessage.put("email", Validator.validateEmail(customer.getEmail()));
        } else {
            customerRepository.save(customer);
        }
        return mapMessage;
    }

    @Override
    public Map<String, String> edit(Customer customer) {
        Map<String, String> mapMessage = new HashMap<>();
        if (Validator.validateDate(customer.getBirthday()) != null
                || Validator.validateIdCard(customer.getCardID()) != null
                || Validator.validatePhone(customer.getPhone()) != null
                || Validator.validateEmail(customer.getEmail()) != null) {
            mapMessage.put("birthday", Validator.validateDate(customer.getBirthday()));
            mapMessage.put("idCard", Validator.validateIdCard(customer.getCardID()));
            mapMessage.put("phone", Validator.validatePhone(customer.getPhone()));
            mapMessage.put("email", Validator.validateEmail(customer.getEmail()));
        } else {
            customerRepository.update(customer);
        }
        return mapMessage;
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public List<Customer> findByContainName(String key) {
        return customerRepository.findByContainName(key);
    }
}
