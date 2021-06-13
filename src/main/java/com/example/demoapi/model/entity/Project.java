package com.example.demoapi.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    @ManyToMany
    @JoinTable(
            name = "user_enrolled",
            joinColumns = @JoinColumn(name = "projectId"),
            inverseJoinColumns =@JoinColumn(name = "user_id")
    )
    private Set<UserData> enrollUsers = new HashSet<>();
    @Column(name = "name_project")
    private String nameProject;

    @Column(name = "action")
    private String action;

    public void enrollUser(UserData userData) {
        enrollUsers.add(userData);
    }
}
