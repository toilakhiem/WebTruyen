package com.example.webtruyen.Core.Domain.Entity.User;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Entity_Permissions")
public class Permissions {
    @Id
    @Column(name = "permission_id")
    public UUID id;
    public String Name;
    public String NormalizedName;
    public String Code;
    public String Description;
    @OneToMany(mappedBy = "permissions")
    public List<RolePermissions> rolesList;

}
