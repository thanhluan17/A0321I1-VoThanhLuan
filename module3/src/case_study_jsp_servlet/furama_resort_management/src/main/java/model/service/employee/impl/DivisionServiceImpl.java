package model.service.employee.impl;

import model.bean.employee.Division;
import model.repository.employee.DivisionRepository;
import model.repository.employee.impl.DivisionRepositoryImpl;
import model.service.employee.DivisionService;

import java.util.List;

public class DivisionServiceImpl implements DivisionService {
    DivisionRepository divisionRepository = new DivisionRepositoryImpl();

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
