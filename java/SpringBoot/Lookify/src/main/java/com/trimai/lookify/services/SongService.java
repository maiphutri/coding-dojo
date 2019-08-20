package com.trimai.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trimai.lookify.models.Song;
import com.trimai.lookify.repositories.SongRepo;

@Service
public class SongService {
	private final SongRepo songRepo;

	public SongService(SongRepo songRepo) {
		this.songRepo = songRepo;
	}
	
	public List<Song> allSongs() {
		return songRepo.findAll();
	}
	
	public Song createSong(Song song) {
		return songRepo.save(song);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalLang = songRepo.findById(id);
		if (optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	public Song updateSong(Long id, String title, String artist, int rating) {
		Optional<Song> song = songRepo.findById(id);
		if (song.isPresent()) {
			Song editSong = song.get();
			editSong.setTitle(title);
			editSong.setArtist(artist);
			editSong.setRating(rating);
			songRepo.save(editSong);
			return editSong;
		} else {
			return null;
		}
	}
	
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	public List<Song> topTen() {
		return songRepo.findAllByOrderByRatingDesc();
	}
	
	public List<Song> artistSearch(String artist) {
		return songRepo.findByArtist(artist);
	}
}
