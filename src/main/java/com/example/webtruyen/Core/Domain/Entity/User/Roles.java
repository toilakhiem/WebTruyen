package com.example.webtruyen.Core.Domain.Entity.User;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Entity_Role")
public class Roles {
    @Id
    @Column(name = "role_id")
    public UUID id;
    public String Name;
    public String NormalizedName;
    public String Code;
    public String Description;
    @OneToMany(mappedBy = "roles")
    public List<RolePermission> rolePermissions;
}
