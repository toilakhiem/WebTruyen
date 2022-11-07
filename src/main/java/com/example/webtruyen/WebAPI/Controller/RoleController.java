package com.example.webtruyen.WebAPI.Controller;

import com.example.webtruyen.Infrastructure.ServiceIpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public ResponseEntity<?> addRoleToPermission(String UserName, String RoleName){
        userService.addRoleToUser(UserName,RoleName);
        return ResponseEntity.ok().body("Thanh Cong");
    }
}
