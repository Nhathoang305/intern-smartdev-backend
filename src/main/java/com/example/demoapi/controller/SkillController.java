package com.example.demoapi.controller;

import com.example.demoapi.model.entity.Skill;
import com.example.demoapi.model.entity.UserData;
import com.example.demoapi.repository.SkillRepository;
import com.example.demoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    List<Skill> getSkill(){
        return skillRepository.findAll();
    }
    @PostMapping
    Skill createSkill(@RequestBody Skill skill){
        return skillRepository.save(skill);
    }
    @PutMapping("/{id}")
    public Skill PutUser(@RequestBody Skill skill, @PathVariable Long id){
        Skill oldUser = skillRepository.findById(id).orElseThrow(RuntimeException::new);
        oldUser.setName(skill.getName());
        oldUser.setAction(skill.getAction());
        return skillRepository.save(oldUser);
    }
    @DeleteMapping("/{skillID}")
    public Long DeleteSkill(@PathVariable Long skillID){
        skillRepository.deleteById(skillID);
        return skillID;
    }
//    @PutMapping("/{skillID}/user/{userID}")
//    Skill enrollSkillToUser(
//            @PathVariable Long userID,
//            @PathVariable Long skillID
//    ){
//        Skill skill = skillRepository.findById(skillID).get();
//        UserData userData = userRepository.findById(userID).get();
//        skill.assignUser(userData);
//        return skillRepository.save(skill);
//    }
}
