package com.example.webtruyen.Infrastructure.ServiceIpl;

import com.example.webtruyen.Core.Application.Service.PermissionServiceInterface;
import com.example.webtruyen.Core.Domain.Entity.User.Permission;
import com.example.webtruyen.Infrastructure.Repositories.User.PermissonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionService implements PermissionServiceInterface {
    @Autowired
    private PermissonRepo permissonRepo;
    @Override @Async
    public Permission saveRole(Permission permission) {
        return permissonRepo.save(permission);
    }

    @Override @Async
    public List<Permission> getAllPermission() {
        return permissonRepo.findAll();
    }
}
