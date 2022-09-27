package com.example.webtruyen.Core.Domain.Entity.User;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class Roles {
        public UUID Id;
        public String Name;
        public String NormalizedName;
        public String Code;
        public String Description;

}
