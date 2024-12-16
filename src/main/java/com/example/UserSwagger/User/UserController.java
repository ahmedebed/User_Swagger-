package com.example.UserSwagger.User;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "User Controller", description = "API for managing users")
public class UserController {

    @Autowired
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/users")
    @Operation(summary = "Get all users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "get user by id")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    @Operation(summary = "Create a new user")
    public User createUser(@RequestBody User user) {
        if (user.getName() == null || user.getName().isEmpty()||user.getPassword()==null||user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return userService.saveUser(user);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user by ID")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
