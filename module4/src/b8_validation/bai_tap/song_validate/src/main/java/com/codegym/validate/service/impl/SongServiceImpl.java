package com.codegym.validate.service.impl;

import com.codegym.validate.model.Song;
import com.codegym.validate.repository.SongRepository;
import com.codegym.validate.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    SongRepository songRepository;

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(Integer id) {
        songRepository.deleteById(id);
    }
}
