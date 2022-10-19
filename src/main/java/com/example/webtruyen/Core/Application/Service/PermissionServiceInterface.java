package com.example.webtruyen.Core.Application.Service;

import com.example.webtruyen.Core.Domain.Entity.User.Permission;

import java.util.List;

public interface PermissionServiceInterface {
    Permission saveRole(Permission permission);
    List<Permission> getAllPermission();
}
