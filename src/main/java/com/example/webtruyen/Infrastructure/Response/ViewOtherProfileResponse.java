package com.example.webtruyen.Infrastructure.Response;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import lombok.Data;

import java.util.List;

@Data
public class ViewOtherProfileResponse {
    public String userName;
    public String firstName;
    public String lastName;
    public String avatar;
    public List<Truyen> truyenCuaTois;
}
