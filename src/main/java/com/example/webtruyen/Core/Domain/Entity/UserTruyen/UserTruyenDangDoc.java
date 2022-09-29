package com.example.webtruyen.Core.Domain.Entity.UserTruyen;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Core.Domain.Entity.User.Accounts;
import com.example.webtruyen.Core.Domain.Entity.User.Permissions;
import com.example.webtruyen.Core.Domain.Entity.User.Roles;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class UserTruyenDangDoc implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "account_id")
    public Accounts accounts;
    @Id
    @ManyToOne
    @JoinColumn(name = "truyen_id")
    public Truyen truyen;
}
