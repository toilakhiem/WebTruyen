package com.example.webtruyen.Core.Domain.Entity.User;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

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
    public String name;
    public String normalizedName;
    public String description;
    @ManyToMany(mappedBy = "roles") @JsonBackReference
    private Collection<User> roles = new HashSet<User>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    @JsonBackReference
    public Collection<Permission> permissions = new ArrayList<>();
    public Role(String name, String normalizedName, String description) {
        this.name = name;
        this.normalizedName = normalizedName;
        this.description = description;
    }
}
