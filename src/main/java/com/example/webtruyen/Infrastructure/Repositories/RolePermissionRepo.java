package com.example.webtruyen.Infrastructure.Repositories;

import com.example.webtruyen.Core.Domain.Entity.User.ID.RolePermissionKey;
import com.example.webtruyen.Core.Domain.Entity.User.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepo extends JpaRepository<RolePermission, RolePermissionKey> {

}
