package com.example.webtruyen.Infrastructure.ServiceIpl;

import com.example.webtruyen.Core.Application.Service.TruyenServiceInterface;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Author;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Chapter;
import com.example.webtruyen.Core.Domain.Entity.Truyen.TheLoai;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Infrastructure.Repositories.Truyen.AuthorRepo;
import com.example.webtruyen.Infrastructure.Repositories.Truyen.ChapterRepo;
import com.example.webtruyen.Infrastructure.Repositories.Truyen.TheLoaiRepo;
import com.example.webtruyen.Infrastructure.Repositories.Truyen.TruyenRepo;
import com.example.webtruyen.Infrastructure.Repositories.User.UserRepo;
import com.example.webtruyen.Infrastructure.Request.AddChapterRequest;
import com.example.webtruyen.Infrastructure.Request.CreateStoryRequest;
import com.example.webtruyen.Infrastructure.Request.PostTruyenByAdminRequest;
import com.example.webtruyen.Infrastructure.Response.GetLastedStoryResponse;
import com.example.webtruyen.Infrastructure.Response.GetStoryByCategoryResponse;
import com.example.webtruyen.Infrastructure.Response.GetStoryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TruyenService implements TruyenServiceInterface {
    @Autowired
    private TruyenRepo truyenRepo;
    @Autowired
    private TheLoaiRepo theLoaiRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private ChapterRepo chapterRepo;
    private ModelMapper modelMapper;

    public TruyenService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public GetStoryResponse getTruyen(String tenTruyen) {
        Truyen truyen = truyenRepo.findByTen(tenTruyen);
        GetStoryResponse response = modelMapper.map(truyen,GetStoryResponse.class);
        return response;
    }

    @Override
    public Truyen saveTruyen(CreateStoryRequest request, String username) {
        Truyen truyen = modelMapper.map(request,Truyen.class);
        truyen.setNgayDang(LocalDateTime.now());
        truyen.setTacGia(userRepo.findByUsername(username));
        TheLoai theLoai = theLoaiRepo.findByTenTheLoai("Kiem_Hiep");
        theLoai.getTruyens().add(truyen);
        return truyenRepo.save(truyen);
    }

    @Override
    public Truyen saveTruyenByAdmin(PostTruyenByAdminRequest request) {
        Truyen truyen = modelMapper.map(request,Truyen.class);
        truyen.setNgayDang(LocalDateTime.now());
        TheLoai theLoai = theLoaiRepo.findByTenTheLoai("Kiem_Hiep");
        theLoai.getTruyens().add(truyen);
        Author tacGia = authorRepo.findByUserName(request.getTacGia());
        tacGia.getTruyens().add(truyen);
        return truyenRepo.save(truyen);
    }

    @Override
    public Truyen postTruyen(Truyen truyen) {
        return null;
    }

    @Override
    public List<GetStoryByCategoryResponse> getTruyenByTheLoai(String tenTheLoai) {
        Pageable paging = PageRequest.of(1, 3);
        List<Truyen> truyens =  truyenRepo.getTruyenByTheLoai(tenTheLoai,paging);
        List<GetStoryByCategoryResponse> dtos = truyens
                .stream()
                .map(truyen -> modelMapper.map(truyen, GetStoryByCategoryResponse.class))
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<GetLastedStoryResponse> getTruyenMoiNhat() {
        Pageable paging = PageRequest.of(0, 3);
        List<Truyen> truyens =  truyenRepo.getTruyenMoiNhat(paging);
        List<GetLastedStoryResponse> dtos = truyens
                .stream()
                .map(truyen -> modelMapper.map(truyen, GetLastedStoryResponse.class))
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<GetLastedStoryResponse> getTruyenMoiCapNhat() {
        Pageable paging = PageRequest.of(0, 3);
        List<Truyen> truyens =  truyenRepo.getTruyenMoiCapNhat(paging);
        List<GetLastedStoryResponse> dtos = truyens
                .stream()
                .map(truyen -> modelMapper.map(truyen, GetLastedStoryResponse.class))
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public void addChapterForStory(AddChapterRequest request, String tenTruyen) {
        Truyen truyen = truyenRepo.findByTen(tenTruyen);
//        Chapter chapter = (Chapter) truyen.getChapterList().stream().collect(Collectors.toList());
        Chapter chapter = new Chapter("Chuong1", 1, "chuong 1", truyen);
        chapterRepo.save(chapter);
        truyen.getChapterList().add(chapter);
    }

}
