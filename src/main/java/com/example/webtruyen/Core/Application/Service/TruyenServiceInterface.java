package com.example.webtruyen.Core.Application.Service;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;

public interface TruyenServiceInterface {
    Truyen getTruyen(String tenTruyen);
    Truyen saveTruyen(Truyen truyen);
}
