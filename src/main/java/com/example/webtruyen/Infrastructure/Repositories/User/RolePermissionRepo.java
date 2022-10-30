package com.example.webtruyen.Infrastructure.Repositories.User;


import com.example.webtruyen.Core.Domain.Entity.User.RolePermission;
import com.example.webtruyen.Core.Domain.Key.RolePermissonKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionRepo extends JpaRepository<RolePermission, RolePermissonKey> {

}
