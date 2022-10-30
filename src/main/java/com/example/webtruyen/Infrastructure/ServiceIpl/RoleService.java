package com.example.webtruyen.Infrastructure.ServiceIpl;

import com.example.webtruyen.Core.Application.Service.RoleServiceInterface;
import com.example.webtruyen.Core.Domain.Entity.User.Role;
import com.example.webtruyen.Infrastructure.Repositories.User.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements RoleServiceInterface {
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public List<Role> AllgetRole() {
        return roleRepo.findAll();
    }
}
