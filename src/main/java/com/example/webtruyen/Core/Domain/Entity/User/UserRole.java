package com.example.webtruyen.Core.Domain.Entity.User;

import com.example.webtruyen.Core.Domain.Entity.User.ID.UserRoleKey;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Entity_UserRoles")
@NoArgsConstructor
public class UserRole implements Serializable {
    @EmbeddedId
    private UserRoleKey userRoleId;
    @ManyToOne @MapsId("userId") @JoinColumn(name = "roles_id")
    public Role roles;
    @ManyToOne @MapsId("roleId") @JoinColumn(name = "accounts_id")
    public User user;

    public UserRole(Role roles, User accounts) {
        this.roles = roles;
        this.user = accounts;
    }
}
