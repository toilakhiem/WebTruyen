package com.example.webtruyen.Core.Domain.Entity.User.ID;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@NoArgsConstructor
public class UserRoleKey implements Serializable {
    private static final long serialVersionUID = -1469598234263842813L;
    @Column(name = "id")
    private UUID userId;
    @Column(name = "id")
    private UUID roleId;

    public UserRoleKey(UUID userId, UUID roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
