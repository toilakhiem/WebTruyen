package com.example.webtruyen.Core.Application.Service;

import com.example.webtruyen.Core.Domain.Entity.User.User;



import java.util.List;

public interface UserServiceInterface {
    User saveUser(User user);
    void addRoleToUser(String userName, String roleName);
    User getUserByName(String name);
    List<User> getAllUsers();

    void Register(User user);
}
