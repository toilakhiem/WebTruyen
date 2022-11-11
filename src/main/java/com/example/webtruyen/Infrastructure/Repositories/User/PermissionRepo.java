package com.example.webtruyen.Infrastructure.Repositories.User;

import com.example.webtruyen.Core.Domain.Entity.User.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, UUID> {
    @Query(value = "select p from Permission p where p.name = ?1")
    Permission findPermissionByName(String PermissonName);
}
