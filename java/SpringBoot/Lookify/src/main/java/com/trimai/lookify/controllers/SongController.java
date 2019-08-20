package com.trimai.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trimai.lookify.models.Song;
import com.trimai.lookify.services.SongService;

@Controller
public class SongController {
	private final SongService songService;

	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "/songs/new.jsp";
	}
	
	@RequestMapping(value="/songs", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "/songs/new.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/songs/" + song.getId();
        }
	}
	
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/songs/show.jsp";
	}
	
	@RequestMapping(value="/songs/{id}/delete", method=RequestMethod.POST)
	public String destroy(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
}
