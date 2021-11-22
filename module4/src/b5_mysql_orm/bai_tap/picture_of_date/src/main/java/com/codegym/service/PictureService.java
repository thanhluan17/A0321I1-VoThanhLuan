package com.codegym.service;

import com.codegym.model.PictureData;

import java.util.List;

public interface PictureService {
    List<PictureData> findAll();

    PictureData save(PictureData pictureData);
}
