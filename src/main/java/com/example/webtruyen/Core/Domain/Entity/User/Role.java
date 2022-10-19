package com.example.webtruyen.Core.Domain.Entity.User;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Data
@Table(name = "Entity_Roles")
public class Role {
    @Id
    @Column(name = "roles_id")
    public UUID id;
    public String Name;
    public String NormalizedName;
    public String Code;
    public String Description;
    @OneToMany(mappedBy = "roles")
    public List<RolePermission> rolePermissions;
    @OneToMany(mappedBy = "roles")
    public List<UserRole> accountRoles;
}
