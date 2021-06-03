package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//Tạo 1 mảng user động để thay cho database và thêm sẵn dữ liệu ban đầu và override method của userService trả về mảng động user
//Nhớ đánh dấu @Component
@Component
public class UserImpl implements UserService{
    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1,"Le Van A","levana@gmail.com","0123456781","avatar01.jpg","levana123"));
        users.add(new User(2,"Le Van B","levanb@gmail.com","0123456782","avatar02.jpg","levana123"));
        users.add(new User(3,"Le Van C","levanc@gmail.com","0123456783","avatar03.jpg","levana123"));
        users.add(new User(4,"Le Van D","levand@gmail.com","0123456784","avatar04.jpg","levana123"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<UserDto>();
        for(User user: users){
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for(User user: users){
            if(user.getId() == id){
                return UserMapper.toUserDto(user);
            }
        }
        return null;
    }

    @Override
    public List<UserDto> seachUser(String name) {
        List<UserDto> result = new ArrayList<UserDto>();
        for(User user: users){
            if (user.getName().contains(name)) {
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }

}
