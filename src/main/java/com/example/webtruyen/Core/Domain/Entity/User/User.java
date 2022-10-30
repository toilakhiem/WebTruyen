package com.example.webtruyen.Core.Domain.Entity.User;


//import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
//    @Column(name = "Id", nullable = false)
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "Email", nullable = false)
    private String Email;
    private String UserName;
    private String NormalizedUserName;
    private String NormalizeEmail;
    private Boolean EmailConfirmed;
    private String Password;
    @OneToMany(mappedBy = "user")
    private List<UserRole> accountRoles = new ArrayList<>();
    @OneToMany(mappedBy = "TacGia")
    private List<Truyen> truyenCuaTois;
//    @OneToMany(mappedBy = "accounts")
//    private List<UserTruyenDangDoc> TruyenDangDoc;

    public User(String email, String userName, String normalizedUserName, String normalizeEmail, Boolean emailConfirmed, String password, List<UserRole> accountRoles, List<Truyen> truyenCuaTois) {
        Email = email;
        UserName = userName;
        NormalizedUserName = normalizedUserName;
        NormalizeEmail = normalizeEmail;
        EmailConfirmed = emailConfirmed;
        Password = password;
        this.accountRoles = accountRoles;
        this.truyenCuaTois = truyenCuaTois;
    }
}
