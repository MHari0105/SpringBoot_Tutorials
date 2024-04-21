package com.myproject.DemoBackend.service.impl;

import com.myproject.DemoBackend.model.User;
import com.myproject.DemoBackend.repository.UserRepository;
import com.myproject.DemoBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public String createUser(User user) {
        userRepo.save(user);
        return "User " + user.getUserId() + " saved";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepo.findById(userId).get();
    }

    @Override
    public String deleteUser(Integer userId) {
        userRepo.deleteById(userId);
        return "User " + userId + " deleted";
    }

    @Override
    public User updateUser(Integer userId, User user) {
        Optional<User> existing = userRepo.findById(userId);

        User existingUser = null;

        if (existing.isPresent()) {
            existingUser = existing.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setAge(user.getAge());
            existingUser.setGender(user.getGender());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());

            userRepo.save(existingUser);
        }

        return existingUser;
    }
}
