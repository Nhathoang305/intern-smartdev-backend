package com.example.demoapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Skills")
public class Skill {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameskill")
    private String name;
    @Column(name = "action")
    private String action;

    @JsonIgnore
    @OneToMany(mappedBy = "skill")
    private Set<UserData> userData = new HashSet<>();

    public Set<UserData> getUserData() {
        return userData;
    }
}
