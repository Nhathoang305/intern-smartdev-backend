package com.example.demoapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "password")
    private String password;

    //cu
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name="skill_id",
            referencedColumnName = "id"

    )
    private Skill skill;
    public Skill getSkill() {
        return skill;
    }
    public void assignSkill(Skill skill) {
        this.skill = skill;
    }
}

