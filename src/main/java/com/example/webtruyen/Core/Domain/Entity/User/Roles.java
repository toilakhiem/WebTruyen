package com.example.webtruyen.Core.Domain.Entity.User;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Entity_Roles")
public class Roles {
    @Id
    @Column(name = "roles_id")
    public UUID id;
    public String Name;
    public String NormalizedName;
    public String Code;
    public String Description;
    @OneToMany(mappedBy = "roles")
    public List<RolePermissions> rolePermissions;
    @OneToMany(mappedBy = "roles")
    public List<AccountRoles> accountRoles;
}
