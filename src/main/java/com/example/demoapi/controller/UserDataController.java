package com.example.demoapi.controller;

import com.example.demoapi.model.entity.Project;
import com.example.demoapi.model.entity.Skill;
import com.example.demoapi.model.entity.UserData;
import com.example.demoapi.model.service.UserDataService;
import com.example.demoapi.repository.SkillRepository;
import com.example.demoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alluser")
public class UserDataController {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private  SkillRepository skillRepository;
    public UserDataController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    UserDataService userDataService;
//    //get all user
//    @GetMapping("/alluser")
//    public ResponseEntity<?> getListUser(){
//        List<UserData> listUser = (ArrayList) userDataService.findAll();
//        return ResponseEntity.ok(listUser);
//    }
//    @GetMapping("/alluser/{id}")
//    public ResponseEntity<?> findById(@PathVariable("id") Integer id){
//        Optional<UserData> listUser = userDataService.findById(id);
//        return ResponseEntity.ok(listUser);
//    }
    @GetMapping("")
    public List<UserData> GetUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public UserData GetUser(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }
    @PostMapping("/")
    public UserData PostUser(@RequestBody UserData userData){
        return userRepository.save(userData);
    }

    @PutMapping("/{id}")
    public UserData PutUser(@RequestBody UserData userData,@PathVariable Long id){
        UserData oldUser = userRepository.findById(id).orElseThrow(RuntimeException::new);
        oldUser.setName(userData.getName());
        oldUser.setEmail(userData.getEmail());
        oldUser.setPhone(userData.getPhone());
        oldUser.setAvatar(userData.getAvatar());
        oldUser.setPassword(userData.getPassword());
        return userRepository.save(oldUser);
    }
//    @DeleteMapping("/{userID}")
//    public void DeleteUser(@PathVariable Long userID,@PathVariable Long skillID){
//        UserData userData = userRepository.findById(userID).get();
//        Skill skill = skillRepository.findById(skillID).get();
//        userData.assignSkill(skill);
//        userRepository.deleteById(userID);
//        return userID;
//    }
        @DeleteMapping("/{userID}")
        public Long DeleteUser(@PathVariable Long userID){
            userRepository.deleteById(userID);
            return userID;
    }
    //cu
    @PutMapping("/{userID}/skills/{skillID}")
    UserData assignSkillToUser(
            @PathVariable Long userID,
            @PathVariable Long skillID
    ){
        UserData userData = userRepository.findById(userID).get();
        Skill skill = skillRepository.findById(skillID).get();
        userData.assignSkill(skill);
        return userRepository.save(userData);
    }

}
