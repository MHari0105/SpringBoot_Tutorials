package com.myproject.DemoBackend.service;

import com.myproject.DemoBackend.model.User;

import java.util.List;

public interface UserService {

    public String createUser(User user);
    public List<User> getAllUsers();
    public User getUserById(Integer userId);
    public String deleteUser(Integer userId);
    public User updateUser(Integer userId, User user);

}
