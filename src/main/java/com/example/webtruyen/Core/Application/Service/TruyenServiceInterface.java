package com.example.webtruyen.Core.Application.Service;

import com.example.webtruyen.Core.Domain.Entity.Truyen.TheLoai;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Infrastructure.Request.CreateStoryRequest;
import com.example.webtruyen.Infrastructure.Response.GetLastedStoryResponse;
import com.example.webtruyen.Infrastructure.Response.GetStoryByCategoryResponse;
import com.example.webtruyen.Infrastructure.Response.GetStoryResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TruyenServiceInterface {
    GetStoryResponse getTruyen(String tenTruyen);
    Truyen saveTruyen(CreateStoryRequest request, String Username);
    Truyen saveTruyenByAdmin(Truyen truyen, String tenTacGia);
    Truyen postTruyen(Truyen truyen);
    List<GetStoryByCategoryResponse> getTruyenByTheLoai(String tenTheLoai);
    List<GetLastedStoryResponse> getTruyenMoiNhat();
    List<GetLastedStoryResponse> getTruyenMoiCapNhat();
}
