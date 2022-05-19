package br.edu.ifms.relacionamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.relacionamentos.model.Project;
import br.edu.ifms.relacionamentos.repository.ProjectRepository;

@Service
public class ProjectService {
    
    @Autowired
    ProjectRepository projectRepository;


    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    
    public Project getProjectById(int id) {
        return projectRepository.getById(id);
    }


    public void saveProject(Project project) {
        projectRepository.save(project);
    }


    public void deleteProjectById(int id) {
        projectRepository.deleteById(id);
    }
}
