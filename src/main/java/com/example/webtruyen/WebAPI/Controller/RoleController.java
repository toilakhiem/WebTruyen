package com.example.webtruyen.WebAPI.Controller;

import com.example.webtruyen.Infrastructure.Response.GetAllRole;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Role")
public class RoleController {
    @GetMapping("/GetAllRole")
    public ResponseEntity<GetAllRole> GetAllRole() {
        return null;
    }
}
