package com.example.webtruyen.Core.Domain.Entity.User;

import com.example.webtruyen.Core.Domain.Entity.User.ID.RolePermissionKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Entity_RolePermissions")
public class RolePermission implements Serializable {
    @EmbeddedId
    private RolePermissionKey rolePermissionKey;
    @ManyToOne @MapsId("roleId") @JoinColumn(name = "role_id")
    public Role roles;
    @ManyToOne @MapsId("permissionId") @JoinColumn(name = "permission_id")
    public Permission permissions;
}
