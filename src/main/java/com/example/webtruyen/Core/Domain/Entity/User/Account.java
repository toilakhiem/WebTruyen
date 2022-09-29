package com.example.webtruyen.Core.Domain.Entity.User;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Entity_Account")
public class Account {
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
}
