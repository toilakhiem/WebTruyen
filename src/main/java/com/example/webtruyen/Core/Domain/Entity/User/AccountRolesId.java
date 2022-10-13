package com.example.webtruyen.Core.Domain.Entity.User;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
@EqualsAndHashCode
public class AccountRolesId implements Serializable {
    public Roles roles;
    public Accounts accounts;
    public AccountRolesId(Roles roles, Accounts accounts) {
        this.roles = roles;
        this.accounts = accounts;
    }
}
