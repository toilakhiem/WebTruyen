package com.example.webtruyen.Core.Domain.Entity.User.ID;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;
@Embeddable
@NoArgsConstructor
public class RolePermissionKey implements Serializable {
    @Column(name = "id")
    private UUID roleId;
    @Column(name = "id")
    private UUID permissionId;

    public RolePermissionKey(UUID roleId, UUID permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }
}
