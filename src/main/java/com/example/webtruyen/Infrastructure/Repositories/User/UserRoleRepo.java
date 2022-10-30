package com.example.webtruyen.Infrastructure.Repositories.User;

import com.example.webtruyen.Core.Domain.Entity.User.UserRole;
import com.example.webtruyen.Core.Domain.Key.UserRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, UserRoleKey> {
}
