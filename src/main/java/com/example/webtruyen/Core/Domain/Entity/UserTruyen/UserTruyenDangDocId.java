package com.example.webtruyen.Core.Domain.Entity.UserTruyen;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Core.Domain.Entity.User.Accounts;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@EqualsAndHashCode
public class UserTruyenDangDocId implements Serializable {
    public Accounts accounts;
    public Truyen truyen;
    public UserTruyenDangDocId(Accounts accounts, Truyen truyen) {
        this.accounts = accounts;
        this.truyen = truyen;
    }
}
