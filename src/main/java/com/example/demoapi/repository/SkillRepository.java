package com.example.demoapi.repository;

import com.example.demoapi.model.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long>{
}
