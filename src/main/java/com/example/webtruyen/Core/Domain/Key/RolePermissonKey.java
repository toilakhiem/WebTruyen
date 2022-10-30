package com.example.webtruyen.Core.Domain.Key;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class RolePermissonKey implements Serializable {
    private Long roleId;
    private Long permissionId;

    public RolePermissonKey(Long roleId, Long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }
}
