package com.example.webtruyen.Infrastructure.Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PostTruyenByAdminRequest {
    public Long id;
    public String tenTruyen;
    public String motaNgan;
    public String tacGia;
}
