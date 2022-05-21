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

import br.edu.ifms.relacionamentos.model.Functionary;
import br.edu.ifms.relacionamentos.model.Project;
import br.edu.ifms.relacionamentos.service.FunctionaryService;
import br.edu.ifms.relacionamentos.service.ProjectService;

@Controller
@RequestMapping("/functionary")
public class FunctionaryController {

    @Autowired
    FunctionaryService functionaryService;

    @Autowired
    ProjectService projectService;
    

    @GetMapping("/")
    public String listAllFunctionaries(Model html) {
        List<Functionary> functionariesList = functionaryService.getAllFunctionaries();
        html.addAttribute("functionariesList", functionariesList);
        html.addAttribute("noDataFunctionary", new Functionary());
        List<Project> projectsList = projectService.getAllProjects();
        html.addAttribute("projectsList", projectsList);
        return "functionary";
    }


    @PostMapping("/save")
    public String saveFunctionary(@ModelAttribute("noDataFunctionary") Functionary functionary) {
        functionaryService.saveFunctionary(functionary);
        return "redirect:/functionary/";
    }


    @GetMapping("/delete/{id}")
    public String deleteFunctionary(@PathVariable("id") int id) {
        functionaryService.deleteFunctionaryById(id);
        return "redirect:/functionary/";
    }


    @PostMapping("/update/{id}")
    public String updateFunctionary(@PathVariable("id") int id, @ModelAttribute("noDataFunctionary") Functionary functionary) {
        functionaryService.saveFunctionary(functionary);
        return "redirect:/functionary/";
    }
}
