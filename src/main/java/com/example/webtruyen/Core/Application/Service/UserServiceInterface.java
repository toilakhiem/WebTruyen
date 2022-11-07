package com.example.webtruyen.Core.Application.Service;

import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.example.webtruyen.Infrastructure.Request.RegisterRequest;
import com.example.webtruyen.Infrastructure.Response.ViewMyProfileResponse;


import java.util.List;

public interface UserServiceInterface {
    User saveUser(User user);
    void addRoleToUser(String userName, String roleName);
    void addPermissionToRole(String RoleName, String PermissionName);
    User getUserByName(String name);
    public ViewMyProfileResponse viewMyProfile(String UserName);
    void Register(RegisterRequest request);
    User ViewOtherProfole(String UserName);
}
