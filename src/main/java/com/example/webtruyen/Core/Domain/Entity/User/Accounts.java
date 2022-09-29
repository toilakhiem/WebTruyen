package com.example.webtruyen.Core.Domain.Entity.User;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Core.Domain.Entity.UserTruyen.UserTruyenDangDoc;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Entity_Account")
public class Accounts {
    @Id
    @Column(name = "Id", nullable = false)
    public UUID id;
    @Column(name = "Email", nullable = false)
    public String Email;
    public String UserName;
    public String NormalizedUserName;
    public String NormalizeEmail;
    public String EmailConfirmed;
    public String PasswordHash;
    public String SecurityStamp;
    public String ConcurrencyStamp;
    public String PhoneNumber;
    public String PhoneNumberConfirmed;
    @OneToMany(mappedBy = "accounts")
    public List<AccountRoles> accountRoles;
    @OneToMany(mappedBy = "TacGia")
    public List<Truyen> TruyenCuaToi;
    @OneToMany(mappedBy = "accounts")
    public List<UserTruyenDangDoc> TruyenDangDoc;

}
