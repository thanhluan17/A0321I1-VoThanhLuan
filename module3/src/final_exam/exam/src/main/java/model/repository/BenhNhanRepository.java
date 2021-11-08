package model.repository;

import model.bean.BenhNhan;

import java.util.List;

public interface BenhNhanRepository {
    List<BenhNhan> findAll();
}
