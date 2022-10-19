package com.example.webtruyen.WebAPI.Controller;

import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.example.webtruyen.Infrastructure.Repositories.UserRepo;
import com.example.webtruyen.Infrastructure.ServiceIpl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(User user){
        return ResponseEntity.ok().body(userService.saveUser(user));
    }
    @GetMapping("/getUserByName")
    public ResponseEntity<User> getUserByName(String UserName){
        return ResponseEntity.ok().body(userService.getUserByName(UserName));
    }
}
