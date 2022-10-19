package com.example.webtruyen.Core.Application.Service;

import com.example.webtruyen.Core.Domain.Entity.User.Role;

import java.util.List;

public interface RoleServiceInterface {
    Role saveRole(Role role);
    List<Role> AllgetRole();
}
