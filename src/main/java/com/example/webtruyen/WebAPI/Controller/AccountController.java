package com.example.webtruyen.WebAPI.Controller;

import com.example.webtruyen.Core.Domain.Entity.User.Accounts;
import com.example.webtruyen.Infrastructure.Request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @PostMapping("/login")
    public ResponseEntity<Accounts> login(LoginRequest request){

        return ResponseEntity.ok().build();
    }
}
