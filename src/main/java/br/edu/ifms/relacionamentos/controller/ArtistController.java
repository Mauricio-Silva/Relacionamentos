package br.edu.ifms.relacionamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.relacionamentos.model.Artist;
import br.edu.ifms.relacionamentos.service.ArtistService;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;
    

    @GetMapping("/")
    public String listAllArtists(Model html) {
        List<Artist> artistsList = artistService.getAllArtists();
        html.addAttribute("artistsList", artistsList);
        html.addAttribute("noDataArtist", new Artist());
        return "artist";
    }


    @PostMapping("/save")
    public String saveArtist(@ModelAttribute("noDataArtist") Artist artist) {
        artistService.saveArtist(artist);
        return "redirect:/artist/";
    }


    @GetMapping("/delete/{id}")
    public String deleteArtist(@PathVariable("id") int id) {
        artistService.deleteArtistById(id);
        return "redirect:/artist/";
    }
    

    @PostMapping("/update/{id}")
    public String updateArtist(@PathVariable("id") int id, @ModelAttribute("noDataArtist") Artist artist) {
        artistService.saveArtist(artist);
        return "redirect:/artist/";
    }
}