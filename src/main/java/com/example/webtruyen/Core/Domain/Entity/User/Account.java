package com.example.webtruyen.Core.Domain.Entity.User;

import lombok.Getter;
import lombok.Setter;

import java.rmi.server.UID;
import java.util.UUID;

@Getter
@Setter
public class Account {
    public UUID Id;
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
