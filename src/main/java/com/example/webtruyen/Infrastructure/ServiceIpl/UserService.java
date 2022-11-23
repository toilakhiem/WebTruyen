package com.example.webtruyen.Infrastructure.ServiceIpl;

import com.example.webtruyen.Core.Application.Service.UserServiceInterface;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Author;
import com.example.webtruyen.Core.Domain.Entity.User.*;
import com.example.webtruyen.Infrastructure.Exception.AppException;
import com.example.webtruyen.Infrastructure.Repositories.Truyen.AuthorRepo;
import com.example.webtruyen.Infrastructure.Repositories.User.*;
import com.example.webtruyen.Infrastructure.Request.ChangeMyPasswordRequest;
import com.example.webtruyen.Infrastructure.Request.CreateUserRequest;
import com.example.webtruyen.Infrastructure.Request.RegisterRequest;
import com.example.webtruyen.Infrastructure.Response.ViewMyProfileResponse;
import com.example.webtruyen.Infrastructure.Response.ViewOtherProfileResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private PermissionRepo permissionRepo;
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    public UserService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    @Async
    public User saveUser(User user) {
        log.info("Saving new user to database");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role r = roleRepo.findByName("ROLE_USER");
        user.getRoles().add(r);
        return userRepo.save(user);
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepo.save(author);
    }

    @Override
    public void createUser(CreateUserRequest request) {
        User user = modelMapper.map(request,User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role r = roleRepo.findByName("ROLE_USER");
        user.getRoles().add(r);
        userRepo.save(user);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = userRepo.findByUsername(userName);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);

    }
    @Override
    public void addPermissionToRole(String RoleName, String PermissionName) {
        Role role = roleRepo.findByName(RoleName);
        Permission permission = permissionRepo.findPermissionByName(PermissionName);
        role.getPermissions().add(permission);
    }

    @Override
    public User getUserByName(String name) {
        User user = userRepo.findByUsername(name);
        if(user == null){
            log.info("User not found");
            throw new UsernameNotFoundException("User not found in db");
        }else{
            log.info("User found : {}", user.getUserName());
        }
        return userRepo.findByUsername(name);
    }

    @Override
    public ViewMyProfileResponse viewMyProfile(String UserName) {
        User user = userRepo.findByUsername(UserName);
        ViewMyProfileResponse viewMyProfileResponse = modelMapper.map(user,ViewMyProfileResponse.class);
        return viewMyProfileResponse;
    }

    @Override
    public void Register(RegisterRequest request) {
        User user = modelMapper.map(request,User.class);
        User duplicatedUser = userRepo.findByUsername(user.getUserName());
        if(duplicatedUser != null) {
            throw new UsernameNotFoundException("Trung Con Me No Roi");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        User userSaver = userRepo.findByUsername(user.getUserName());
        Role role = roleRepo.findByName("ROLE_USER");
        userSaver.getRoles().add(role);
    }

    @Override
    public ViewOtherProfileResponse ViewOtherProfole(String UserName) {
        User user = userRepo.findByUsername(UserName);
        ViewOtherProfileResponse viewOtherProfileResponse = modelMapper.map(user,ViewOtherProfileResponse.class);
        return viewOtherProfileResponse;
    }


    @Override
    public void ChangeMyPassword(ChangeMyPasswordRequest request, String UserName) throws AppException{
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = userRepo.findByUsername(UserName);
        if(bCryptPasswordEncoder.matches(request.oldPassword, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(request.newPassword));
        }
        else throw new AppException("Mat Khau Cu sai");
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
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            role.getPermissions().forEach(permission -> {
                authorities.add(new SimpleGrantedAuthority(permission.getName()));
            });
        });
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }

}
