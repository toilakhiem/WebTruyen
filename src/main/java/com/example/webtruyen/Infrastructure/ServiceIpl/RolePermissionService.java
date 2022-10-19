package com.example.webtruyen.Infrastructure.ServiceIpl;

import com.example.webtruyen.Core.Application.Service.RolePermissionServiceInterface;
import com.example.webtruyen.Infrastructure.Repositories.PermissonRepo;
import com.example.webtruyen.Infrastructure.Repositories.RolePermissionRepo;
import com.example.webtruyen.Infrastructure.Repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class RolePermissionService implements RolePermissionServiceInterface {
    @Autowired
    private PermissonRepo permissonRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private RolePermissionRepo rolePermissionRepo;
    @Override
    public void addPermissonToRole(String RoleName, String PermissonName) {

    }
}
