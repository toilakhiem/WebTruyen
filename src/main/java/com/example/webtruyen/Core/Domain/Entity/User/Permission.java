package com.example.webtruyen.Core.Domain.Entity.User;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Permission {
    public UUID Id;
    public String Name;
    public String NormalizedName;
    public String Code;
    public String Description;

    @ManyToMany
    List<Roles> rolesList;

}
