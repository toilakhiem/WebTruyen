package com.example.webtruyen.WebAPI.Controller;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Chapter;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Core.Domain.Entity.User.Role;
import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.example.webtruyen.Infrastructure.Repositories.Truyen.TruyenRepo;
//import com.example.webtruyen.Infrastructure.ServiceIpl.TruyenService;
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

@RestController
@RequestMapping("/truyen")
public class TruyenController {
    @Autowired
    private TruyenService truyenService;
    @Autowired
    private UserService userService;
    @GetMapping("/get/{tenTruyen}")
    public ResponseEntity<Truyen> getTruyen(@PathVariable(name = "tenTruyen") String tenTruyen){

        return ResponseEntity.ok().body(truyenService.getTruyen(tenTruyen));
    }
    @PostMapping("/postByAdmin")
    public ResponseEntity<?> DangTruyenBoiAdmin(Truyen truyen){
        return ResponseEntity.ok().body(truyenService.saveTruyen(truyen));
    }

    @PostMapping("/get/truyen/{theLoai}")
    public ResponseEntity<Page<Truyen>> GetTruyenByCategory(@PathVariable(name = "theLoai") String theLoai){
        return ResponseEntity.ok().body(truyenService.getTruyenByTheLoai(theLoai));
    }
    @PostMapping("/get/truyen/lastPost")
    public ResponseEntity<?> GetTruyenByLastPost(){
        return ResponseEntity.ok().body("");
    }
    @PostMapping("/get/truyen/lastUpdate")
    public ResponseEntity<?> GetTruyenByLastUpdate(){
        return ResponseEntity.ok().body("");
    }


//    @PostMapping("/post")
//    public ResponseEntity<?> DangTruyen(Truyen truyen, HttpServletResponse response) throws IOException {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        roleService.saveRole(new Role("ROLE_AUTHOR_" + truyen.getTen().toUpperCase(),"ROLE_AUTHOR_" + truyen.getTen().toUpperCase(),"2","ADMIN"));
//        userService.addRoleToUser((String) auth.getPrincipal(),"ROLE_AUTHOR_" + truyen.getTen().toUpperCase());
//        truyenService.saveTruyen(truyen);
//        String curl = "localhost:8888/user/refresh_token";
////
//        return ResponseEntity.status(200).location(URI.create(curl)).build();
//    }

//    @PostMapping("/post")
//    @PreAuthorize()
//    public ResponseEntity<?> ThemChuong(String tenTruyen, Chapter){
//
//        return ResponseEntity.ok().body(truyenService.saveTruyen(truyen));
//    }
}
