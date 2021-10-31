package model.service.employee.impl;

import model.bean.employee.Position;
import model.repository.employee.PositionRepository;
import model.repository.employee.impl.PositionRepositoryImpl;
import model.service.employee.PositionService;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    PositionRepository positionRepository = new PositionRepositoryImpl();

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
