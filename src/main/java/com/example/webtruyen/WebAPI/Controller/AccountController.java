package com.example.webtruyen.WebAPI.Controller;

import com.example.webtruyen.Core.Domain.Entity.User.Accounts;
import com.example.webtruyen.Infrastructure.Request.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    //ADMIN
    @PostMapping("/login")
    public ResponseEntity<Accounts> login(LoginRequest request){

        return ResponseEntity.ok().build();
    }
    @PostMapping("/AddPermissionToRole")
    public ResponseEntity<?> AddPermissionToRole(AddPermissionToRole request){

        return ResponseEntity.ok().build();
    }
    @PostMapping("/AddRoleToUser")
    public ResponseEntity<?> AddRoleToUser(AddRoleToUser request){

        return ResponseEntity.ok().build();
    }
    @PostMapping("/CreatePermissionRequest")
    public ResponseEntity<?> CreatePermissionRequest(CreatePermissionRequest request){

        return ResponseEntity.ok().build();
    }
    @PostMapping("/CreateRoleRequest")
    public ResponseEntity<?> CreateRoleRequest(CreateRoleRequest request){

        return ResponseEntity.ok().build();
    }
    @PostMapping("/CreateUserRequest")
    public ResponseEntity<?> CreateUserRequest(CreateUserRequest request){

        return ResponseEntity.ok().build();
    }
    //User
    @PostMapping("/chagepassword")
    public ResponseEntity<?> chagepassword(ChageMyPasswordRequest request){

        return ResponseEntity.ok().build();
    }
    @PostMapping("/viewprofile")
    public ResponseEntity<?> viewprofile(ViewProfileRequest request){

        return ResponseEntity.ok().build();
    }
    //Host
    @PostMapping("/register")
    public ResponseEntity<?> Register(RegisterRequest request){

        return ResponseEntity.ok().build();
    }
}
