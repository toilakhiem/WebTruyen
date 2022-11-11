package com.example.webtruyen.Core.Application.Service;

import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.example.webtruyen.Infrastructure.Exception.AppException;
import com.example.webtruyen.Infrastructure.Request.ChangeMyPasswordRequest;
import com.example.webtruyen.Infrastructure.Request.CreateUserRequest;
import com.example.webtruyen.Infrastructure.Request.RegisterRequest;
import com.example.webtruyen.Infrastructure.Response.ViewMyProfileResponse;
import com.example.webtruyen.Infrastructure.Response.ViewOtherProfileResponse;


import java.util.List;

public interface UserServiceInterface {
    User saveUser(User user);
    void createUser(CreateUserRequest request);
    void addRoleToUser(String userName, String roleName);
    void addPermissionToRole(String RoleName, String PermissionName);
    User getUserByName(String name);
    public ViewMyProfileResponse viewMyProfile(String UserName);
    void Register(RegisterRequest request);
    public ViewOtherProfileResponse ViewOtherProfole(String UserName);
    void ChangeMyPassword(ChangeMyPasswordRequest request, String UserName) throws AppException;
}
