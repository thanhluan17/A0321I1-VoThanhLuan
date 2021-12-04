package com.codegym.validate.service;

import com.codegym.validate.model.Song;

public interface SongService {
    Iterable<Song> findAll();

    Song findById(Integer id);

    void save(Song song);

    void remove(Integer id);
}
