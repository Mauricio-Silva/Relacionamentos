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

import br.edu.ifms.relacionamentos.model.Publisher;
import br.edu.ifms.relacionamentos.service.PublisherService;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
 
    @Autowired
    PublisherService publisherService;


    @GetMapping("/")
    public String listAllPublishers(Model html) {
        List<Publisher> publishersList = publisherService.getAllPublishers();
        html.addAttribute("publishersList", publishersList);
        html.addAttribute("noDataPublisher", new Publisher());
        return "publisher";
    }


    @PostMapping("/save")
    public String savePublisher(@ModelAttribute("noDataPublisher") Publisher publisher) {
        publisherService.savePublisher(publisher);
        return "redirect:/publisher/";
    }


    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable("id") int id) {
        publisherService.deletePublisherById(id);
        return "redirect:/publisher/";
    }


    @PostMapping("/update/{id}")
    public String updatePublisher(@PathVariable("id") int id, @ModelAttribute("noDataPublisher") Publisher publisher) {
        publisherService.savePublisher(publisher);
        return "redirect:/publisher/";
    }
}
