package com.trimai.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.lookify.models.Song;

@Repository
public interface SongRepo extends CrudRepository<Song, Long> {
	List<Song> findAll();
	List<Song> findAllByOrderByRatingDesc();
	List<Song> findByArtist(String search);
}
