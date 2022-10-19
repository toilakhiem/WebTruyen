package com.example.webtruyen.Infrastructure.ServiceIpl;

import com.example.webtruyen.Core.Application.Service.UserServiceInterface;
import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.example.webtruyen.Infrastructure.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepo userRepo;
    @Override
    @Async
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
    }

    @Override
    @Async
    public User getUserByName(String name) {
        return userRepo.findByUsername(name);
    }

    @Override
    @Async
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
