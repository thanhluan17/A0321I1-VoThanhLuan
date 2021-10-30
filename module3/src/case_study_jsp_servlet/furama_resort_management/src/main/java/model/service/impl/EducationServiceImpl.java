package model.service.impl;

import model.bean.employee.Education;
import model.repository.EducationRepository;
import model.repository.impl.EducationRepositoryImpl;
import model.service.EducationService;

import java.util.List;

public class EducationServiceImpl implements EducationService {
    EducationRepository educationRepository = new EducationRepositoryImpl();

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }
}
