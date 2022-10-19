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
@Table(name = "Entity_User")
public class User {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "UUID", strategy = "uuid")
    public UUID id;
    @Column(name = "Email", nullable = false)
    private String Email;
    private String UserName;
    private String NormalizedUserName;
    private String NormalizeEmail;
    private Boolean EmailConfirmed;
    private String Password;
    @OneToMany(mappedBy = "user")
    private List<UserRole> accountRoles;
//    @OneToMany(mappedBy = "TacGia")
//    private List<Truyen> TruyenCuaToi;
//    @OneToMany(mappedBy = "accounts")
//    private List<UserTruyenDangDoc> TruyenDangDoc;

}
