package com.example.webtruyen.Infrastructure.Repositories;

import com.example.webtruyen.Core.Domain.Entity.User.ID.UserRoleKey;
import com.example.webtruyen.Core.Domain.Entity.User.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRole, UserRoleKey> {

}
