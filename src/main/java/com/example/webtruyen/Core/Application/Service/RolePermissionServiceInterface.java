package com.example.webtruyen.Core.Application.Service;

import com.example.webtruyen.Core.Domain.Entity.User.RolePermission;

public interface RolePermissionServiceInterface {
    void addPermissonToRole(String RoleName, String PermissonName);
}
