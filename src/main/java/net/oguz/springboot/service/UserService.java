package net.oguz.springboot.service;

import net.oguz.springboot.dto.UserDto;
import net.oguz.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);
    void deleteUser(long id);
}
