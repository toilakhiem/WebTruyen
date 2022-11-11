package com.example.webtruyen.WebAPI.Controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Core.Domain.Entity.User.Role;
import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.example.webtruyen.Infrastructure.Exception.AppException;
import com.example.webtruyen.Infrastructure.Request.ChangeMyPasswordRequest;
import com.example.webtruyen.Infrastructure.Request.CreateStoryRequest;
import com.example.webtruyen.Infrastructure.Request.RegisterRequest;
import com.example.webtruyen.Infrastructure.Response.ViewMyProfileResponse;
import com.example.webtruyen.Infrastructure.Response.ViewOtherProfileResponse;
import com.example.webtruyen.Infrastructure.ServiceIpl.RoleService;
import com.example.webtruyen.Infrastructure.ServiceIpl.TruyenService;
import com.example.webtruyen.Infrastructure.ServiceIpl.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/user")
@Slf4j
@PermitAll
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TruyenService truyenService;
    @PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> Resgister(@RequestBody RegisterRequest request){
        userService.Register(request);
        return ResponseEntity.ok().body("Dang Ky Thanh Cong");
    }
    @GetMapping(value = "/me")
    public ResponseEntity<ViewMyProfileResponse> viewMyProFile(){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return ResponseEntity.ok().body(userService.viewMyProfile(username));
    }
    @PostMapping(value = "/changeMyPassword", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ChangeMyPassword(@RequestBody ChangeMyPasswordRequest request){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        try {
            userService.ChangeMyPassword(request, username);
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body("Doi Mk Thanh Cong");
    }
    @GetMapping("{username}/view")
    public ResponseEntity<ViewOtherProfileResponse> viewOtherProFile(@PathVariable(value = "username") String username){
        return ResponseEntity.ok().body(userService.ViewOtherProfole(username));
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping(value =  "/post/Truyen", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> DangTruyen(@RequestBody CreateStoryRequest request) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        roleService.saveRole(new Role("ROLE_AUTHOR_" + request.getTenTruyen().toUpperCase(),"ROLE_AUTHOR_" + request.getTenTruyen().toUpperCase(),"Tac Gia cua Truyen " + request.getTenTruyen()));
        userService.addRoleToUser((String) auth.getPrincipal(),"ROLE_AUTHOR_" + request.getTenTruyen().toUpperCase());
        truyenService.saveTruyen(request,auth.getName());
        return ResponseEntity.ok().body("Dang Truyen Thanh Cong");
    }
    @PostMapping("/refresh_token")
    public void RefreshToken(HttpServletRequest request, HttpServletResponse response) throws IndexOutOfBoundsException, IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getUserByName(username);
                //map(Role::getName)
                Set<GrantedAuthority> authorities = new HashSet<>();
                user.getRoles().forEach(role -> {
                    authorities.add(new SimpleGrantedAuthority(role.getName()));
                    role.getPermissions().forEach(permission -> {
                        authorities.add(new SimpleGrantedAuthority(permission.getName()));
                    });
                });
                String access_token = JWT.create()
                        .withSubject(user.getUserName())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 300000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",authorities.stream().map(authority -> authority.getAuthority()).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception e) {
                log.error("Erorr logging in: {} ", e.getMessage());
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String,String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else throw new RuntimeException("Refresh token is missing");
    }
}
