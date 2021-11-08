package model.service.impl;

import model.bean.BenhAn;
import model.repository.BenhAnRepository;
import model.repository.impl.BenhAnRepositoryImpl;
import model.service.BenhAnService;

import java.util.List;

public class BenhAnServiceImpl implements BenhAnService {
    BenhAnRepository benhAnRepository = new BenhAnRepositoryImpl();

    @Override
    public List<BenhAn> findAll() {
        return benhAnRepository.findAll();
    }

    @Override
    public void save(BenhAn benhAn) {
        benhAnRepository.save(benhAn);
    }

    @Override
    public int delete(int ma_benh_an) {
        return benhAnRepository.delete(ma_benh_an);
    }

    @Override
    public void update(BenhAn benhAn) {
        benhAnRepository.update(benhAn);
    }

    @Override
    public BenhAn findById(int ma_benh_an) {
        return benhAnRepository.findById(ma_benh_an);
    }
}
