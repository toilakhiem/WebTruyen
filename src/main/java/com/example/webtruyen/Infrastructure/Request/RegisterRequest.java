package com.example.webtruyen.Infrastructure.Request;

import lombok.Data;

import java.util.Date;
@Data
public class RegisterRequest {
    public String email;
    public String userName;
    public String password;
    public String firstName;
    public String lastName;
}
