package com.example.demo;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(final User user){
        final User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        LocalDateTime now = LocalDateTime.now();
        newUser.setCreated(now);
        newUser.setUpdated(now);

        return userRepository.save(newUser);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
