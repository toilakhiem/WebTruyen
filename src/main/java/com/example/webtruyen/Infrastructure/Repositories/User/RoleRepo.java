package com.example.webtruyen.Infrastructure.Repositories.User;

import com.example.webtruyen.Core.Domain.Entity.User.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    @Query(value = "select  * from Role r where r.Name = ?1",nativeQuery = true)
    Role findByName(String name);
}
