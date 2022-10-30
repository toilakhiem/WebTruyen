package com.example.webtruyen.Infrastructure.ServiceIpl;

import com.example.webtruyen.Core.Application.Service.UserServiceInterface;
import com.example.webtruyen.Core.Domain.Entity.User.Role;
import com.example.webtruyen.Core.Domain.Entity.User.RolePermission;
import com.example.webtruyen.Core.Domain.Entity.User.User;
//import com.example.webtruyen.Core.Domain.Entity.User.UserRole;
import com.example.webtruyen.Core.Domain.Entity.User.UserRole;
import com.example.webtruyen.Core.Domain.Key.UserRoleKey;
import com.example.webtruyen.Infrastructure.Repositories.User.RoleRepo;
import com.example.webtruyen.Infrastructure.Repositories.User.UserRepo;
import com.example.webtruyen.Infrastructure.Repositories.User.UserRoleRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Slf4j
@Transactional
public class UserService implements UserServiceInterface, UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRoleRepo userRoleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    @Async
    public User saveUser(User user) {
        log.info("Saving new user to database");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = userRepo.findByUsername(userName);
        Role role = roleRepo.findByName(roleName);
        UserRole userRole = new UserRole(new UserRoleKey(role.getId(),user.getId()),role,user);
        userRoleRepo.save(userRole);
        user.getAccountRoles().add(userRole);
        role.getAccountRoles().add(userRole);

    }

    @Override
    @Async
    public User getUserByName(String name) {
        return userRepo.findByUsername(name);
    }

    @Override
    @Async
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void Register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        User userSaver = userRepo.findByUsername(user.getUserName());
        Role role = roleRepo.findByName("ROLE_USER");
        UserRole userRole = new UserRole(new UserRoleKey(role.getId(),userSaver.getId()),role,userSaver);
        userRoleRepo.save(userRole);
        userSaver.getAccountRoles().add(userRole);
        role.getAccountRoles().add(userRole);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null){
            log.info("User not found");
            throw new UsernameNotFoundException("User not found in db");
        }else{
            log.info("User found : {}", username);
        }
        Set<GrantedAuthority> authorities = new HashSet<>();

        for (UserRole userRole : user.getAccountRoles()) {
            authorities.add(new SimpleGrantedAuthority(userRole.getRoles().getName()));
            for (RolePermission rolePermission : userRole.getRoles().getRolePermissions()) {
                authorities.add(new SimpleGrantedAuthority(rolePermission.getPermissions().getName()));
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);

    }
}
