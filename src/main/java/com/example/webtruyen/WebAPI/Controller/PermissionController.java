package com.example.webtruyen.WebAPI.Controller;

import com.example.webtruyen.Infrastructure.ServiceIpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
@PreAuthorize("hasRole('SUPER_ADMIN')")
public class PermissionController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public ResponseEntity<?> addPermission(String RoleName, String PerName){
        userService.addPermissionToRole(RoleName,PerName);
        return ResponseEntity.ok().body("Thanh Cong");
    }
}
