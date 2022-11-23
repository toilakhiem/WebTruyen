package com.example.webtruyen.Infrastructure.Request;

import lombok.Data;

@Data
public class PostTruyenByAdminRequest {
    public Long id;
    public String tenTruyen;
    public String motaNgan;
    private String tacGia;
}
