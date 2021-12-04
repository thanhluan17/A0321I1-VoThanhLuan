package com.codegym.validate.repository;

import com.codegym.validate.model.Song;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SongRepository extends PagingAndSortingRepository<Song, Integer> {
}
