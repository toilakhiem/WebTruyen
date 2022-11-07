package com.example.webtruyen.Core.Application.Service;

import com.example.webtruyen.Core.Domain.Entity.Truyen.TheLoai;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TruyenServiceInterface {
    Truyen getTruyen(String tenTruyen);
    Truyen saveTruyen(Truyen truyen);
    Truyen postTruyen(Truyen truyen);
    Page<Truyen> getTruyenByTheLoai(String tenTheLoai);
}
