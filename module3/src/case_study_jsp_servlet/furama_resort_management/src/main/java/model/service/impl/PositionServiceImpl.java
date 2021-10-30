package model.service.impl;

import model.bean.employee.Position;
import model.repository.PositionRepository;
import model.repository.impl.PositionRepositoryImpl;
import model.service.PositionService;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    PositionRepository positionRepository = new PositionRepositoryImpl();

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
