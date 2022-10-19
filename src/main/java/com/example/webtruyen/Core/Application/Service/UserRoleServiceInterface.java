package com.example.webtruyen.Core.Application.Service;

import com.example.webtruyen.Core.Domain.Entity.User.UserRole;

public interface UserRoleServiceInterface {
    void addRoleToUser(String UserName, String RoleName);
}
