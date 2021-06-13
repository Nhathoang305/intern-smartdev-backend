package com.example.demoapi.controller;

import com.example.demoapi.model.entity.Project;
import com.example.demoapi.model.entity.Skill;
import com.example.demoapi.model.entity.UserData;
import com.example.demoapi.repository.ProjectRepository;
import com.example.demoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    List<Project> getProject(){
        return projectRepository.findAll();
    }
    @GetMapping("/{id}")
    public Project GetUser(@PathVariable Long id){
        return projectRepository.findById(id).orElse(null);
    }
    @PostMapping
    Project createProject(@RequestBody Project project){
        return projectRepository.save(project);
    }
    @PutMapping("/{id}")
    public Project PutUser(@RequestBody Project project, @PathVariable Long id){
        Project oldUser = projectRepository.findById(id).orElseThrow(RuntimeException::new);
        oldUser.setNameProject(project.getNameProject());
        oldUser.setAction(project.getAction());
        return projectRepository.save(oldUser);
    }
    @PutMapping("/{projectID}/user/{userID}")
    Project enrollUserToProject(
            @PathVariable Long projectID,
            @PathVariable Long userID
    ){
        Project project = projectRepository.findById(projectID).get();
        UserData userData = userRepository.findById(userID).get();
        project.enrollUser(userData);
        return projectRepository.save(project);
    }
    @DeleteMapping("/{projectID}")
    public Long DeleteProject(@PathVariable Long projectID){
        projectRepository.deleteById(projectID);
        return projectID;
    }
}
