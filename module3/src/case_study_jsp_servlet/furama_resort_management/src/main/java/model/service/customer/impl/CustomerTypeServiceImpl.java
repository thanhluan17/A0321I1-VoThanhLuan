package model.service.customer.impl;

import model.bean.customer.CustomerType;
import model.repository.customer.CustomerTypeRepository;
import model.repository.customer.impl.CustomerTypeRepositoryImpl;
import model.service.customer.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
