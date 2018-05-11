package com.umanav.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umanav.lookify.models.Song;
import com.umanav.lookify.repositories.SongRepsoitory;

@Service
public class SongService {
	private SongRepsoitory songRepository;
    public SongService(SongRepsoitory songRepository){
        this.songRepository = songRepository;
    }
    public List<Song> allSongs(){
        return songRepository.findAll();
    }
    public void addSong(Song song){
        songRepository.save(song);
    }
    public void destroySong(Long id){
        songRepository.deleteById(id);
    }
    public List<Song> songs_Artist(String artist){
    	return songRepository.findByArtistContaining(artist);
 
    }
	public Song getSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		return optionalSong.get();
	}
	public void updateSong(Song song) {
		songRepository.save(song);
	}
	public List<Song> topSongs(){ 
		return songRepository.findTop10ByRatingOrderByRatingDesc(1);
	}
}
