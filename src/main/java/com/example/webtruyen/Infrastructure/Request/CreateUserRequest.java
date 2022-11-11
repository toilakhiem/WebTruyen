package com.example.webtruyen.Infrastructure.Request;

import lombok.Data;

import java.util.Date;
@Data
public class CreateUserRequest {
    public String Email;
    public String UserName;
    public String Password;
    public String FirstName;
    public String LastName;
    public Date Dob;
}
