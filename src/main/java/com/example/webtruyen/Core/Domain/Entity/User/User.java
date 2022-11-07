package com.example.webtruyen.Core.Domain.Entity.User;


//import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import lombok.AllArgsConstructor;
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
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    public UUID id;
    @Column(nullable = false, unique = true)
    private String Email;
    @Column(nullable = false, unique = true)
    private String UserName;
    private String NormalizeEmail;
    private Boolean EmailConfirmed = false;
    @Column(nullable = false)
    private String Password;
    private String Avatar;
    @Column(nullable = false)
    private String FirstName;
    @Column(nullable = false)
    private String LastName;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
    @ManyToMany
    private Collection<Truyen> truyenCuaTois = new ArrayList<>();
    @ManyToMany
    private Collection<Truyen> TruyenDangDoc = new ArrayList<>();

    public User(String email, String userName, String password, String firstName, String lastName) {
        Email = email;
        UserName = userName;
        Password = password;
        FirstName = firstName;
        LastName = lastName;
    }
}
