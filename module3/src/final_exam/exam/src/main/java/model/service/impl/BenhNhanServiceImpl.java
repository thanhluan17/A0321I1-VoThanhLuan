package model.service.impl;

import model.bean.BenhNhan;
import model.repository.BenhNhanRepository;
import model.repository.impl.BenhNhanRepositoryImpl;
import model.service.BenhNhanService;

import java.util.List;

public class BenhNhanServiceImpl implements BenhNhanService {
    BenhNhanRepository benhNhanRepository = new BenhNhanRepositoryImpl();

    @Override
    public List<BenhNhan> findAll() {
        return benhNhanRepository.findAll();
    }
}
