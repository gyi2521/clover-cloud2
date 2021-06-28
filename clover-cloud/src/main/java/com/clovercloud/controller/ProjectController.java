package com.clovercloud.controller;

import com.clovercloud.model.Project;
import com.clovercloud.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")

public class ProjectController {

    @Autowired
    ProjectRepository projectRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@RequestBody Project project)  {
        return projectRepo.save(project);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Project getOneProject(@PathVariable Integer id)  {
        return projectRepo.getById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProject(@RequestBody Project project, @PathVariable Integer id ) {
        projectRepo.save(project);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProject(@PathVariable Integer id){
        projectRepo.deleteById(id);
    }

}
