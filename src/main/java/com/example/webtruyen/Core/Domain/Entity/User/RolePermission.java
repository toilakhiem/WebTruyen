package com.example.webtruyen.Core.Domain.Entity.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Entity_RolePermission")
public class RolePermission implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "roles_id")
    public Roles roles;
    @Id
    @ManyToOne
    @JoinColumn(name = "permission_id")
    public Permission permission;
}
