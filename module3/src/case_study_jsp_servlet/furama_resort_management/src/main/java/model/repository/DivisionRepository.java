package model.repository;

import model.bean.employee.Division;
import model.bean.employee.Position;

import java.util.List;

public interface DivisionRepository {
    List<Division>findAll();
}
