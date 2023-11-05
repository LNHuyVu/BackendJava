package com.example.example3.service.impl;

import java.util.List;

import com.example.example3.entity.User;
import com.example.example3.repository.UserRespository;
import com.example.example3.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRespository userRespository;

    @Override
    public User createUser(User user) {
        return userRespository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRespository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRespository.findAll();
    }

    // Not update email
    @Override
    public User updateUser(User user) {
        User existingUser = userRespository.findById(user.getId()).get();
        existingUser.setFullname(user.getFullname());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhone_number(user.getPhone_number());
        existingUser.setAddress(user.getAddress());
        existingUser.setCreated_at(user.getCreated_at());
        existingUser.setUpdated_at(user.getUpdated_at());
        existingUser.setDeleted(user.getDeleted());
        User updatedUser = userRespository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRespository.deleteById(userId);
    }
}
