package net.oguz.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.oguz.springboot.dto.UserDto;
import net.oguz.springboot.entity.User;
import net.oguz.springboot.exception.exceptions.EmailAlreadyExistException;
import net.oguz.springboot.exception.exceptions.ResourceNotFoundException;
import net.oguz.springboot.mapper.AutoUserMapper;
import net.oguz.springboot.repository.UserRepository;
import net.oguz.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {

        Optional<User> userOptional = userRepository.findByEmail(userDto.getEmail());

        if(userOptional.isPresent())
        {
            throw new EmailAlreadyExistException("Email Already Exists");
        }

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User updatedUser = userRepository.save(user);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public UserDto getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user ->
                        modelMapper
                                .map(
                                        user,
                                        UserDto.class
                                )
                )
                .toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);

        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(long id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        userRepository.deleteById(id);
    }
}
