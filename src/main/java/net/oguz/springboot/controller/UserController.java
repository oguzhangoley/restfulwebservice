package net.oguz.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.oguz.springboot.dto.UserDto;
import net.oguz.springboot.entity.User;
import net.oguz.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD Rest API for User Resource",
        description = "some description"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @Operation(
            summary = "Create User Rest API",
            description = "create User"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201"
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User By Id Rest API",
            description = "Get User By Id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
        UserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
            summary = "Get User All Rest API",
            description = "Get User All"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(
            summary = "Update User Rest API",
            description = "Update User"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id
            , @RequestBody @Valid UserDto user) {
        user.setId(id);
        UserDto uptadedUser = userService.updateUser(user);
        return new ResponseEntity<>(uptadedUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User By Id Rest API",
            description = "Delete User By Id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User Successfully deleted", HttpStatus.OK);
    }

}
