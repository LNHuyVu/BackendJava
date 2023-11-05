package com.example.example3.service;

import java.util.List;

import com.example.example3.entity.User;

public interface UserService {

    public User createUser(User user);

    public User getUserById(Long userId);

    public List<User> getAllUsers();

    public User updateUser(User user);

    public void deleteUser(Long userId);
}