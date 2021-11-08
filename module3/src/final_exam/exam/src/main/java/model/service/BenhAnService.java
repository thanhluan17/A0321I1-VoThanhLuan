package model.service;

import model.bean.BenhAn;

import java.util.List;

public interface BenhAnService {
    List<BenhAn> findAll();

    void save(BenhAn benhAn);

    int delete(int ma_benh_an);

    void update(BenhAn benhAn);

    BenhAn findById(int ma_benh_an);
}
