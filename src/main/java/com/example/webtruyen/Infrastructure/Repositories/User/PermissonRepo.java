package com.example.webtruyen.Infrastructure.Repositories.User;

import com.example.webtruyen.Core.Domain.Entity.User.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PermissonRepo extends JpaRepository<Permission, Long> {
    @Query(value = "select * from Permission p where p.Name = ?1", nativeQuery = true)
    Permission findPermissionByName(String PermissonName);
}
