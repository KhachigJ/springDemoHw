package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @PostMapping()
    public UserDto createUser(@RequestBody final UserCreationRequestDTO requestDTO) {
        final User user = new User();
        user.setName(requestDTO.getName());
        user.setEmail(requestDTO.getEmail());

        User newUser = userService.createUser(user);

        return convertToUserDto(newUser);
    }

    private UserDto convertToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreated(),
                user.getUpdated()
        );
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers().stream().map(this::convertToUserDto).toList();
    }
}
