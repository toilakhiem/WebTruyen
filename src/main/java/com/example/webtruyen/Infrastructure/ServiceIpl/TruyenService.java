package com.example.webtruyen.Infrastructure.ServiceIpl;

import com.example.webtruyen.Core.Application.Service.TruyenServiceInterface;
import com.example.webtruyen.Core.Domain.Entity.Truyen.TheLoai;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Infrastructure.Repositories.Truyen.TheLoaiRepo;
import com.example.webtruyen.Infrastructure.Repositories.Truyen.TruyenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TruyenService implements TruyenServiceInterface {
    @Autowired
    private TruyenRepo truyenRepo;
    @Autowired
    private TheLoaiRepo theLoaiRepo;
    @Override
    public Truyen getTruyen(String tenTruyen) {
        return truyenRepo.findByTen(tenTruyen);
    }

    @Override
    public Truyen saveTruyen(Truyen truyen) {
        truyen.setNgayDang(LocalDateTime.now());
        return truyenRepo.save(truyen);
    }

    @Override
    public Truyen postTruyen(Truyen truyen) {
        return null;
    }

    @Override
    public Page<Truyen> getTruyenByTheLoai(String tenTheLoai) {
        Pageable paging = PageRequest.of(0, 3);
        Page<Truyen> truyens = truyenRepo.getTruyenByTheLoai(tenTheLoai,paging);
        return truyens;
    }

}
