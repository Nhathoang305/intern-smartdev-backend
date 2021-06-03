package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller là nơi tiếp nhận và xử lý các request
//Nhớ đánh dấu @RestController
@RestController
//Phần chung url của các method sử dụng RequestMapping
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/seach")
    public  ResponseEntity<?> seachUser(@RequestParam(name="keyword", required = false, defaultValue = "") String name){
        List<UserDto> user = userService.seachUser(name);
        return ResponseEntity.ok(user);
    }
    //Method Get dữ liệu dùng @GetMapping truyền vào url
    @GetMapping("")
    public ResponseEntity<?> getListUser(){
        //gọi sang service lấy ra danh sách user sau đó trả về cho client
        List<UserDto> users= userService.getListUser();
        return ResponseEntity.ok(users);
    }
    //Method Get dữ liệu dùng @GetMapping truyền vào url
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable  int id){
        //gọi sang service lấy ra danh sách user sau đó trả về cho client
//        List<User> result = userService.getUserById(id);
        UserDto result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }
    //Method Post dữ liệu dùng @GetMapping truyền vào url
    @PostMapping("")
    public ResponseEntity<?> createUser(){
        return null;
    }
    //Method Put dữ liệu dùng @GetMapping truyền vào url
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(){
        return null;
    }
    //Method Delete dữ liệu dùng @GetMapping truyền vào url
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(){
        return null;
    }

}
