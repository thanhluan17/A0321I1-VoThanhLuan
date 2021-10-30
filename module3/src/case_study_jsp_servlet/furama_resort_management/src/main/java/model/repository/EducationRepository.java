package model.repository;

import model.bean.employee.Education;
import model.bean.employee.Position;

import java.util.List;

public interface EducationRepository {
    List<Education>findAll();
}
