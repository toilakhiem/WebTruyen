package com.example.webtruyen.Core.Domain.Entity.User;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Table(name = "Permission")
@NoArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
    @Column(unique = true, nullable = false)
    private String name;
    private String normalizedName;
    private String description;
    @ManyToMany(mappedBy = "permissions") @JsonBackReference
    private Collection<Role> roles = new ArrayList<>();

    public Permission(String name) {
        this.name = name;
    }
}
