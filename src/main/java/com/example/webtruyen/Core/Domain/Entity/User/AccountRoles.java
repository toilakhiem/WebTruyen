package com.example.webtruyen.Core.Domain.Entity.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Entity_AccountRoles")
public class AccountRoles implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "roles_id")
    public Roles roles;
    @Id
    @ManyToOne
    @JoinColumn(name = "accounts_id")
    public Accounts accounts;
}
