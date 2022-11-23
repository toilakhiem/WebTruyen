package com.example.webtruyen.WebAPI.Controller;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Author;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.example.webtruyen.Infrastructure.ServiceIpl.TheLoaiService;
import com.example.webtruyen.Infrastructure.ServiceIpl.TruyenService;
import com.example.webtruyen.Infrastructure.ServiceIpl.UserService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private TheLoaiService theLoaiService;
    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(User user){
        return ResponseEntity.ok().body(userService.saveUser(user));
    }
    @PostMapping("/saveAuthor")
    public ResponseEntity<?> saveAuthor(Author author){
        userService.saveAuthor(author);
        return ResponseEntity.ok().body("Save Thanh cong");
    }
//    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ROLE_SUPER_ADMIN')")
//    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @GetMapping("/getUserByName")
    public ResponseEntity<User> getUserByName(String UserName){
        return ResponseEntity.ok().body(userService.getUserByName(UserName));
    }
    @GetMapping("/themTheLoai")
    public ResponseEntity<?> themTheLoai(String theLoai){
        return ResponseEntity.ok().body(theLoaiService.themTheLoai(theLoai));
    }
}
