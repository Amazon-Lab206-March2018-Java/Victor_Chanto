package com.umanav.lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.umanav.lookify.models.Song;

public interface SongRepsoitory extends CrudRepository<Song, Long> {
	List<Song> findAll();
	List<Song> findByArtistContaining(String artist);
	List<Song> findTop10ByRatingOrderByRatingDesc(int rating);

}

