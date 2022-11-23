package com.example.webtruyen.WebAPI.Controller;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Chapter;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Core.Domain.Entity.User.Role;
import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.example.webtruyen.Infrastructure.Repositories.Truyen.TruyenRepo;
//import com.example.webtruyen.Infrastructure.ServiceIpl.TruyenService;
import com.example.webtruyen.Infrastructure.Request.AddChapterRequest;
import com.example.webtruyen.Infrastructure.Request.PostTruyenByAdminRequest;
import com.example.webtruyen.Infrastructure.Response.GetLastedStoryResponse;
import com.example.webtruyen.Infrastructure.Response.GetStoryByCategoryResponse;
import com.example.webtruyen.Infrastructure.Response.GetStoryResponse;
import com.example.webtruyen.Infrastructure.ServiceIpl.RoleService;
import com.example.webtruyen.Infrastructure.ServiceIpl.TruyenService;
import com.example.webtruyen.Infrastructure.ServiceIpl.UserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/truyen")
public class TruyenController {
    @Autowired
    private TruyenService truyenService;
    @Autowired
    private UserService userService;
    @GetMapping("/get/{tenTruyen}")
    public ResponseEntity<GetStoryResponse> getTruyen(@PathVariable(name = "tenTruyen") String tenTruyen){
        return ResponseEntity.ok().body(truyenService.getTruyen(tenTruyen));
    }
    @GetMapping("/get/{tenTruyen}/{chapter}")
    public ResponseEntity<GetStoryResponse> docTruyen(@PathVariable(name = "tenTruyen") String tenTruyen,@PathVariable(name = "chapter") int chapter){

        return ResponseEntity.ok().body(truyenService.getTruyen(tenTruyen));
    }

    @GetMapping("/get/truyen/{theLoai}")
    public ResponseEntity<List<GetStoryByCategoryResponse>> GetTruyenByCategory(@PathVariable(name = "theLoai") String theLoai){
        return ResponseEntity.ok().body(truyenService.getTruyenByTheLoai(theLoai));
    }
    @GetMapping("/get/truyen/lastPost")
    public ResponseEntity<List<GetLastedStoryResponse>> GetTruyenByLastPost(){
        return ResponseEntity.ok().body(truyenService.getTruyenMoiNhat());
    }
    @PostMapping("/get/truyen/lastUpdate")
    public ResponseEntity<?> GetTruyenByLastUpdate(){
        return ResponseEntity.ok().body(truyenService.getTruyenMoiCapNhat());
    }

    @PostMapping(value = "/postTruyenByAdmin", consumes = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ROLE_SUPER_ADMIN')")
    public ResponseEntity<?> postByAdmin(PostTruyenByAdminRequest request){
        return ResponseEntity.ok().body(truyenService.saveTruyenByAdmin(request));
    }
    @GetMapping("/get/{tenTruyen}/{chapter}/get")
    public ResponseEntity<?> getChapter(@PathVariable(name = "tenTruyen") String tenTruyen,@PathVariable(name = "chapter") int chapter){
        return ResponseEntity.ok().body("done");
    }
    @GetMapping("/get/{tenTruyen}/{chapter}/add")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ROLE_SUPER_ADMIN', 'AUTHOR_' + #tenTruyen.toUpperCase())")
    public ResponseEntity<?> addChapter(@PathVariable(name = "tenTruyen") String tenTruyen, @PathVariable(name = "chapter") int chapter, AddChapterRequest request){
        truyenService.addChapterForStory(request, tenTruyen);
        return ResponseEntity.ok().body("Them Chap Thanh Cong");
    }
    @GetMapping("/get/{tenTruyen}/{chapter}/edit")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ROLE_SUPER_ADMIN', 'AUTHOR_' + #tenTruyen.toUpperCase())")
    public ResponseEntity<GetStoryResponse> editChapter(@PathVariable(name = "tenTruyen") String tenTruyen,@PathVariable(name = "chapter") int chapter){

        return ResponseEntity.ok().body(truyenService.getTruyen(tenTruyen));
    }
    @GetMapping("/test")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ROLE_SUPER_ADMIN')")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok().body("Done");
    }

}
