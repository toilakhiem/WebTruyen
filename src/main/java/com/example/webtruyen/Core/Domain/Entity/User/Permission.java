package com.example.webtruyen.Core.Domain.Entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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
    public UUID id;
    @Column(unique = true, nullable = false)
    public String Name;
    public String NormalizedName;
    public String Description;

    public Permission(String name) {
        Name = name;
    }
}
