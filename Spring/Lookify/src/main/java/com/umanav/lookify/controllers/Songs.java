package com.umanav.lookify.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.umanav.lookify.models.Song;
import com.umanav.lookify.services.SongService;

@Controller
public class Songs {
	// add the Language Serivce 
		private final SongService songService;
		
		// create the constructor
		public Songs (SongService songService) {
			this.songService = songService;
		}
		// Redirect to Main 
		@RequestMapping("/")
		public String main() {
			return "Main.jsp";
		}
		@RequestMapping("/dashboard")
		public String dashboard(Model model) {
			List<Song> songs = songService.allSongs();
			model.addAttribute("songs", songs);
			return "dashboard.jsp";
		}
		
		@PostMapping("/search/")
		public String search(@RequestParam(value="artist") String artist ,Model m) {
			m.addAttribute("artist",artist);
			m.addAttribute("songs_by_artist", songService.songs_Artist(artist));
			return "artist_results.jsp";
		}
		@RequestMapping("/songs/new")
		public String addSong(@ModelAttribute("song") Song song) {
			return "new.jsp";
		}
		@PostMapping("/songs/new")
		public String newsong(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
			if (result.hasErrors()) {
				return "new.jsp";
		    }else{
		    	songService.addSong(song);;
		    	return "redirect:/dashboard";
		    }
		}
		@RequestMapping("/songs/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			songService.destroySong(id);
			return "redirect:/dashboard";
		}
		@RequestMapping("/songs/{id}")
		public String song(@PathVariable("id") Long id, Model model) {
			Song song = songService.getSong(id);
			model.addAttribute("song", song);
			return "song_info.jsp";
		}
		@RequestMapping("/search/topTen")
		public String song(Model model) {
			List<Song> songs = songService.topSongs();
			model.addAttribute("songs", songs);
			return "song_results.jsp";
		}
		
}

