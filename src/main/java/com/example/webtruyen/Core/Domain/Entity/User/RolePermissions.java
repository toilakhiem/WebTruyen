package com.example.webtruyen.Core.Domain.Entity.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Entity_RolePermissions")
public class RolePermissions implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    public Roles roles;
    @Id
    @ManyToOne
    @JoinColumn(name = "permission_id")
    public Permissions permissions;
}
