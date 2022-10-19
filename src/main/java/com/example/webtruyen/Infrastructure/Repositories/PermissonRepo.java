package com.example.webtruyen.Infrastructure.Repositories;

import com.example.webtruyen.Core.Domain.Entity.User.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface PermissonRepo extends JpaRepository<Permission, UUID> {
    @Query(value = "select * from Permission p where p.Name = ?1", nativeQuery = true)
    Permission findPermissionByName(String PermissonName);
}
