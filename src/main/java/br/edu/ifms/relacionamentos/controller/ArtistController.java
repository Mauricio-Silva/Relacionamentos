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
import br.edu.ifms.relacionamentos.model.Webtoon;
import br.edu.ifms.relacionamentos.service.ArtistService;
import br.edu.ifms.relacionamentos.service.WebtoonService;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @Autowired
    WebtoonService webtoonService;
    

    @GetMapping("/")
    public String listAllArtists(Model html) {
        List<Artist> artistsList = artistService.getAllArtists();
        html.addAttribute("artistsList", artistsList);
        html.addAttribute("noDataArtist", new Artist());
        List<Webtoon> webtoonsList = webtoonService.getAllWebtoons();
        html.addAttribute("webtoonsList", webtoonsList);
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


    @GetMapping("/ass/{ArtistID}/{WebtoonID}")
    public String associateArtist(@PathVariable("ArtistID") int ArtistID, @PathVariable("WebtoonID") int WebtoonID) {
        Artist artist = artistService.getArtistById(ArtistID);
        Webtoon webtoon = webtoonService.getWebtoonById(WebtoonID);

        List<Webtoon> artistWebtoonsList = artist.getWebtoons();
        artistWebtoonsList.add(webtoon);
        artistService.saveArtist(artist);

        webtoon.setArtist(artist);
        webtoonService.saveWebtoon(webtoon);
        
        return "redirect:/artist/";
    }
}
