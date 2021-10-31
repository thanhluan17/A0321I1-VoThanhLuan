package model.service.employee.impl;

import model.bean.employee.Education;
import model.repository.employee.EducationRepository;
import model.repository.employee.impl.EducationRepositoryImpl;
import model.service.employee.EducationService;

import java.util.List;

public class EducationServiceImpl implements EducationService {
    EducationRepository educationRepository = new EducationRepositoryImpl();

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }
}
