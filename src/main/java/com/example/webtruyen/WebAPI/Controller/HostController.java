package com.example.webtruyen.WebAPI.Controller;

import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.example.webtruyen.Infrastructure.ServiceIpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/host")
public class HostController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> Resgister(User user){
        userService.Register(user);
        return ResponseEntity.ok().body("Thanh Cong");
    }
}
