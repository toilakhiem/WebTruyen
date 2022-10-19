package com.example.webtruyen.Core.Domain.Entity.User;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
@EqualsAndHashCode
public class RolePermissionsId implements Serializable {
    public Roles roles;
    public Permissions permissions;
    public RolePermissionsId(Roles roles, Permissions permissions) {
        this.roles = roles;
        this.permissions = permissions;
    }
}
