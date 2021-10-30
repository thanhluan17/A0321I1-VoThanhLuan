package model.repository;

import model.bean.employee.Position;

import java.util.List;

public interface PositionRepository {
    List<Position>findAll();
}
