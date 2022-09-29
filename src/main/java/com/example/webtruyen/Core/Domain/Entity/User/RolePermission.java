package com.example.webtruyen.Core.Domain.Entity.User;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Entity_RolePermission")
public class RolePermission {
    @Id
    public UUID RoleId;
    @Id
    public UUID PermissionId;
    @ManyToOne
    @JoinColumn(name = "role_id")
    public Roles roles;
    @ManyToOne
    @JoinColumn(name = "permission_id")
    public Permission permission;
}
