package com.example.webtruyen.Core.Application.Service;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Infrastructure.Request.AddChapterRequest;
import com.example.webtruyen.Infrastructure.Request.CreateStoryRequest;
import com.example.webtruyen.Infrastructure.Request.PostTruyenByAdminRequest;
import com.example.webtruyen.Infrastructure.Response.GetLastedStoryResponse;
import com.example.webtruyen.Infrastructure.Response.GetStoryByCategoryResponse;
import com.example.webtruyen.Infrastructure.Response.GetStoryResponse;

import java.util.List;

public interface TruyenServiceInterface {
    GetStoryResponse getTruyen(String tenTruyen);
    Truyen saveTruyen(CreateStoryRequest request, String Username);
    Truyen saveTruyenByAdmin(PostTruyenByAdminRequest request);
    Truyen postTruyen(Truyen truyen);
    List<GetStoryByCategoryResponse> getTruyenByTheLoai(String tenTheLoai);
    List<GetLastedStoryResponse> getTruyenMoiNhat();
    List<GetLastedStoryResponse> getTruyenMoiCapNhat();
    void addChapterForStory(AddChapterRequest request, String tenTruyen);
}
