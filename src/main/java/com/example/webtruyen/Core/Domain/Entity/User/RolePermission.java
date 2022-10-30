package com.example.webtruyen.Core.Domain.Entity.User;

import com.example.webtruyen.Core.Domain.Key.RolePermissonKey;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RolePermission")
@Getter
@Setter
public class RolePermission implements Serializable {
    @EmbeddedId
    private RolePermissonKey rolePermissionKey;
    @ManyToOne @MapsId("roleId") @JoinColumn(name = "role_id")
    public Role roles;
    @ManyToOne @MapsId("permissionId") @JoinColumn(name = "permission_id")
    public Permission permissions;
}
