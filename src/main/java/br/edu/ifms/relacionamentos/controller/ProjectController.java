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
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    ProjectService projectService;

    @Autowired
    FunctionaryService functionaryService;

    @GetMapping("/")
    public String listAllProjects(Model html) {
        List<Project> projectsList = projectService.getAllProjects();
        html.addAttribute("projectsList", projectsList);
        html.addAttribute("noDataProject", new Project());
        List<Functionary> functionariesList = functionaryService.getAllFunctionaries();
        html.addAttribute("functionariesList", functionariesList);
        return "project";
    }


    @PostMapping("/save")
    public String saveProject(@ModelAttribute("noDataProject") Project project) {
        projectService.saveProject(project);
        return "redirect:/project/";
    }


    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") int id) {
        projectService.deleteProjectById(id);
        return "redirect:/project/";
    }
    

    @PostMapping("/update/{id}")
    public String updateProject(@PathVariable("id") int id, @ModelAttribute("noDataProject") Project project) {
        projectService.saveProject(project);
        return "redirect:/project/";
    }
}
