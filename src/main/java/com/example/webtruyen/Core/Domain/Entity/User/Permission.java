package com.example.webtruyen.Core.Domain.Entity.User;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String Name;
    public String NormalizedName;
    public String Code;
    public String Description;
    @OneToMany(mappedBy = "permissions")
    public List<RolePermission> rolesList;

}
