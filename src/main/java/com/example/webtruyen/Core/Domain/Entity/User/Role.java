package com.example.webtruyen.Core.Domain.Entity.User;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Data
@Table(name = "Role")
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
//    @Column(name = "roles_id", nullable = false)
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String Name;
    public String NormalizedName;
    public String Code;
    public String Description;
    @OneToMany(mappedBy = "roles")
    public Collection<RolePermission> rolePermissions;
    @OneToMany(mappedBy = "roles")
    public List<UserRole> accountRoles = new ArrayList<>();

    public Role(String name, String normalizedName, String code, String description, List<RolePermission> rolePermissions, List<UserRole> accountRoles) {
        Name = name;
        NormalizedName = normalizedName;
        Code = code;
        Description = description;
        this.rolePermissions = rolePermissions;
        this.accountRoles = accountRoles;
    }
}
