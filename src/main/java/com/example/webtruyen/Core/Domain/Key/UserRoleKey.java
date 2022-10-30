package com.example.webtruyen.Core.Domain.Key;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class UserRoleKey implements Serializable {
    private static final long serialVersionUID = -1469598234263842813L;
    private Long userId;
    private Long roleId;

    public UserRoleKey(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
