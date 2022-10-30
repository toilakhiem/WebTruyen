package com.example.webtruyen.Core.Domain.Entity.User;

import com.example.webtruyen.Core.Domain.Key.UserRoleKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserRole")
@NoArgsConstructor
@Getter
@Setter
public class UserRole implements Serializable {
    @EmbeddedId
    private UserRoleKey userRoleKey;
    @ManyToOne @MapsId("roleId")
    public Role roles;
    @ManyToOne @MapsId("userId")
    public User user;

    public UserRole(UserRoleKey userRoleKey, Role roles, User user) {
        this.userRoleKey = userRoleKey;
        this.roles = roles;
        this.user = user;
    }
}
