package model.service;

import model.bean.employee.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
}
