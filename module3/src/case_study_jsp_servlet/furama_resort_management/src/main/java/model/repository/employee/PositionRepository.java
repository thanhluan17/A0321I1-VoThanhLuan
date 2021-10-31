package model.repository.employee;

import model.bean.employee.Position;

import java.util.List;

public interface PositionRepository {
    List<Position>findAll();
}
