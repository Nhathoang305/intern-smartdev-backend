package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
//Khai báo method lấy ra danh sách user có kiểu trả về là list user
//Nhớ khai Báo @Service
@Service
public interface UserService {
    public List<UserDto> getListUser();

    public UserDto getUserById(int id);

    public List<UserDto> seachUser(String name);
}
