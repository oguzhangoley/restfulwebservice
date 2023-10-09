package net.oguz.springboot.mapper;

import net.oguz.springboot.dto.UserDto;
import net.oguz.springboot.entity.User;

import java.util.List;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

    public static User mapToUserEntity(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }

    public static List<UserDto> mapToListUserDto(List<User> users) {
        List<UserDto> userDtoList = users.stream().map(user ->
                new UserDto(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail()
                )).toList();
        return userDtoList;
    }

    public static List<User> mapToListUserEntity(List<UserDto> userDtoList) {
        List<User> userList = userDtoList.stream().map(user ->
                new User(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail()
                )).toList();
        return userList;
    }
}
