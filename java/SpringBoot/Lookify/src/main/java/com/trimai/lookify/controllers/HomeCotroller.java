package com.trimai.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trimai.lookify.models.Song;
import com.trimai.lookify.services.SongService;

@Controller
public class HomeCotroller {
	
	@Autowired
	private SongService songService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/dashboard/index.jsp";
	}
	
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> songs = songService.topTen();
		model.addAttribute("songs", songs);
		return "/search/topten.jsp";
	}
	
	@GetMapping("/search/{artist}")
	public String showArtistSongs(@PathVariable("artist") String artist, Model model) {
		List<Song> songs = songService.artistSearch(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artistName", artist);
		return "/search/artist.jsp";
	}
	
	@PostMapping("/search")
	public String searchArtist(@RequestParam("artist") String artist) {
		return "redirect:/search/" + artist;
	}
}
