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
import br.edu.ifms.relacionamentos.model.Publisher;
import br.edu.ifms.relacionamentos.model.Webtoon;
import br.edu.ifms.relacionamentos.service.ArtistService;
import br.edu.ifms.relacionamentos.service.PublisherService;
import br.edu.ifms.relacionamentos.service.WebtoonService;

@Controller
@RequestMapping("/webtoon")
public class WebtoonController {
 
    @Autowired
    WebtoonService webtoonService;

    @Autowired
    PublisherService publisherService;

    @Autowired
    ArtistService artistService;


    @GetMapping("/")
    public String listAllWebtoons(Model html) {
        List<Webtoon> webtoonsList = webtoonService.getAllWebtoons();
        html.addAttribute("webtoonsList", webtoonsList);
        html.addAttribute("noDataWebtoon", new Webtoon());
        List<Publisher> publishersList = publisherService.getAllPublishers();
        html.addAttribute("publishersList", publishersList);
        List<Artist> artistsList = artistService.getAllArtists();
        html.addAttribute("artistsList", artistsList);
        return "webtoon";
    }


    @PostMapping("/save")
    public String saveWebtoon(@ModelAttribute("noDataWebtoon") Webtoon webtoon) {
        webtoonService.saveWebtoon(webtoon);
        return "redirect:/webtoon/";
    }


    @GetMapping("/delete/{id}")
    public String deleteWebtoon(@PathVariable("id") int id) {
        webtoonService.deleteWebtoonById(id);
        return "redirect:/webtoon/";
    }


    @PostMapping("/update/{id}")
    public String updateWebtoon(@PathVariable("id") int id, @ModelAttribute("noDataWebtoon") Webtoon webtoon) {
        webtoonService.saveWebtoon(webtoon);
        return "redirect:/webtoon/";
    }
}
