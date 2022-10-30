package com.example.webtruyen;

import com.example.webtruyen.Core.Domain.Entity.User.Role;
import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.example.webtruyen.Infrastructure.ServiceIpl.RoleService;
import com.example.webtruyen.Infrastructure.ServiceIpl.UserService;
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
    CommandLineRunner runner(UserService userService, RoleService roleService){
    return args -> {

//            userService.saveRole(new Role(null,"ROLE_USER"));
//            userService.saveRole(new Role(null,"ROLE_ADMIN"));
//            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
//
//            userServiceIpl.saveUser(new User(null, "Khiem", "admin", "admin", new ArrayList<>()));
//            userServiceIpl.addRoleToUser("admin", "ROLE_SUPER_ADMIN");
        roleService.saveRole(new Role("ROLE_ADMIN","ROLE_ADMIN","2","ADMIN",new ArrayList<>(), new ArrayList<>()));
        roleService.saveRole(new Role("ROLE_USER","ROLE_USER","3","USER",new ArrayList<>(), new ArrayList<>()));
        roleService.saveRole(new Role("ROLE_SUPER_ADMIN","ROLE_SUPER_ADMIN","1","SUPER_ADMIN",new ArrayList<>(),new ArrayList<>()));

        userService.saveUser(new User("khiem171222@gmail.com","admin","ADMIN","khiem171222@gmail.com",true,"admin",new ArrayList<>(), new ArrayList<>()));
        userService.addRoleToUser("admin","ROLE_SUPER_ADMIN");
        };
    }
}
