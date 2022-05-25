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

import br.edu.ifms.relacionamentos.model.Genre;
import br.edu.ifms.relacionamentos.service.GenreService;

@Controller
@RequestMapping("/genre")
public class GenreController {
    
    @Autowired
    GenreService genreService;


    @GetMapping("/")
    public String listAllGenres(Model html) {
        List<Genre> genresList = genreService.getAllGenres();
        html.addAttribute("genresList", genresList);
        html.addAttribute("noDataGenre", new Genre());
        return "genre";
    }


    @PostMapping("/save")
    public String saveGenre(@ModelAttribute("noDataGenre") Genre genre) {
        genreService.saveGenre(genre);
        return "redirect:/genre/";
    }


    @GetMapping("/delete/{id}")
    public String deleteGenre(@PathVariable("id") int id) {
        genreService.deleteGenreById(id);
        return "redirect:/genre/";
    }


    @PostMapping("/update/{id}")
    public String updateGenre(@PathVariable("id") int id, @ModelAttribute("noDataGenre") Genre genre) {
        genreService.saveGenre(genre);
        return "redirect:/artist/";
    }
}
