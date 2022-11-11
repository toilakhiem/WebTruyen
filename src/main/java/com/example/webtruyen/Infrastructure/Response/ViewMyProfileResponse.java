package com.example.webtruyen.Infrastructure.Response;

import lombok.Data;

@Data
public class ViewMyProfileResponse {
    public String email;
    public String userName;
    public String avatar;
    public String firstName;
    public String lastName;
}
