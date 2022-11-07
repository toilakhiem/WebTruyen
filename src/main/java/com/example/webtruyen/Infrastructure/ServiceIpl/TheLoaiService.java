package com.example.webtruyen.Infrastructure.ServiceIpl;

import com.example.webtruyen.Core.Application.Service.TheLoaiServiceInterface;
import com.example.webtruyen.Core.Domain.Entity.Truyen.TheLoai;
import com.example.webtruyen.Infrastructure.Repositories.Truyen.TheLoaiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheLoaiService implements TheLoaiServiceInterface {
    @Autowired
    private TheLoaiRepo theLoaiRepo;
    @Override
    public TheLoai themTheLoai(String TenTheLoai) {
        TheLoai theLoai = new TheLoai();
        return theLoaiRepo.save(theLoai);
    }
}
