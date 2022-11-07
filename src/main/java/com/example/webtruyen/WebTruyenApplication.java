package com.example.webtruyen;

import com.example.webtruyen.Core.Domain.Entity.User.Permission;
import com.example.webtruyen.Core.Domain.Entity.User.Role;
import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.example.webtruyen.Infrastructure.ServiceIpl.PermissionService;
import com.example.webtruyen.Infrastructure.ServiceIpl.RoleService;
import com.example.webtruyen.Infrastructure.ServiceIpl.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class WebTruyenApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebTruyenApplication.class, args);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    CommandLineRunner runner(UserService userService, RoleService roleService, PermissionService permissionService){
    return args -> {
        roleService.saveRole(new Role("ROLE_ADMIN","ROLE_ADMIN","ADMIN"));
        roleService.saveRole(new Role("ROLE_USER","ROLE_USER","USER"));
        roleService.saveRole(new Role("ROLE_SUPER_ADMIN","ROLE_SUPER_ADMIN","SUPER_ADMIN"));
        userService.saveUser(new User("khiem171222@gmail.com","admin","admin","admin","admin"));
        permissionService.savePermission(new Permission("user:write"));
        userService.addRoleToUser("admin","ROLE_SUPER_ADMIN");
        userService.addPermissionToRole("ROLE_SUPER_ADMIN","user:write");
        };
    }
}
