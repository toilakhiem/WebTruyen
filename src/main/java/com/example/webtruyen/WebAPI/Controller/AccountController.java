//package com.example.webtruyen.WebAPI.Controller;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.example.webtruyen.Core.Domain.Entity.User.Role;
//import com.example.webtruyen.Core.Domain.Entity.User.User;
//import com.example.webtruyen.Infrastructure.ServiceIpl.RoleServiceIpl;
//import com.example.webtruyen.Infrastructure.ServiceIpl.UserServiceIpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.net.URI;
//import java.util.*;
//import java.util.stream.Collectors;
//import static org.springframework.http.HttpHeaders.AUTHORIZATION;
//import static org.springframework.http.HttpStatus.FORBIDDEN;
//
//@RestController
//@RequestMapping("/api")
//@Slf4j
//public class AccountController {
//    @Autowired
//    private UserServiceIpl userService;
//    @Autowired
//    private RoleServiceIpl roleService;
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ADMIN')")
//    @GetMapping("/user/getUser")
//    public ResponseEntity<List<User>> getUsers(){
//        return ResponseEntity.ok().body(userService.getAllUsers());
//    }
//    @PostMapping ("/user/saveUser")
//    public ResponseEntity<User> SaveUsers(User user){
//        //Lấy thông tin base URL
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/saveUser").toUriString());
//        return ResponseEntity.created(uri).body(userService.saveUser(user));
//    }
//    @PostMapping ("/user/saveRole")
//    public ResponseEntity<Role> AddRole(@RequestBody Role role){
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/saveRole").toUriString());
//        return ResponseEntity.created(uri).body(roleService.saveRole(role));
//    }
//    @PostMapping ("/user/saveRoleToUser")
//    public ResponseEntity<?> AddRoleToUser(RoleToUser roleToUser){
//        userService.addRoleToUser(roleToUser.username,roleToUser.rolename);
//        return ResponseEntity.ok().build();
//    }
//    @PostMapping("/refresh_token")
//    public void RefreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String authorizationHeader = request.getHeader(AUTHORIZATION);
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            try {
//                String refresh_token = authorizationHeader.substring("Bearer ".length());
//                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
//                JWTVerifier verifier = JWT.require(algorithm).build();
//                DecodedJWT decodedJWT = verifier.verify(refresh_token);
//                String username = decodedJWT.getSubject();
//                User user = userService.getUser(username);
//                Role role = roleService.
//                String access_token = JWT.create()
//                        .withSubject(user.getUserName())
//                        .withExpiresAt(new Date(System.currentTimeMillis() + 300000))
//                        .withIssuer(request.getRequestURL().toString())
//                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
//                        .sign(algorithm);
//                Map<String, String> tokens = new HashMap<>();
//                tokens.put("access_token", access_token);
//                tokens.put("refresh_token", refresh_token);
//                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
//            } catch (Exception e) {
//                log.error("Erorr logging in: {} ", e.getMessage());
//                response.setHeader("error", e.getMessage());
//                response.setStatus(FORBIDDEN.value());
//                Map<String,String> error = new HashMap<>();
//                error.put("error_message", e.getMessage());
//                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//                new ObjectMapper().writeValue(response.getOutputStream(), error);
//            }
//        } else throw new RuntimeException("Refresh token is missing");
//    }
//
//
//    @Data
//    class RoleToUser{
//        private String username;
//        private String rolename;
//    }
//}
//
//
