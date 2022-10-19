package com.example.webtruyen.Infrastructure.Repositories;

import com.example.webtruyen.Core.Domain.Entity.User.Role;

import com.example.webtruyen.Core.Domain.Entity.User.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface RoleRepo extends JpaRepository<Role, UUID> {
    @Query(value = "select  * from Role r where r.Name = ?1",nativeQuery = true)
    Role findByName(String name);
}
