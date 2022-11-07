package com.example.webtruyen.Core.Domain.Entity.User;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    public UUID id;
    @Column(unique = true, nullable = false)
    public String Name;
    public String NormalizedName;
    public String Description;
    @ManyToMany(fetch = FetchType.EAGER)
    public Collection<Permission> permissions;

    public Role(String name, String normalizedName, String description) {
        Name = name;
        NormalizedName = normalizedName;
        Description = description;
    }
}
