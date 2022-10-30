package com.example.webtruyen.Infrastructure.ServiceIpl;

import com.example.webtruyen.Core.Application.Service.TruyenServiceInterface;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Infrastructure.Repositories.Truyen.TruyenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TruyenService implements TruyenServiceInterface {
    @Autowired
    private TruyenRepo truyenRepo;
    @Override
    public Truyen getTruyen(String tenTruyen) {
        return truyenRepo.findByTen(tenTruyen);
    }

    @Override
    public Truyen saveTruyen(Truyen truyen) {
        return truyenRepo.save(truyen);
    }
}
