package com.example.webtruyen.WebAPI.Security;

import com.example.webtruyen.WebAPI.Filter.CustomAuthenticationFilter;
import com.example.webtruyen.WebAPI.Filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //chỉ quan tâm
    // 1: protected void configure(HttpSecurity http) : Override this method to configure the HttpSecurity : https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html
    // 2: void	configure (WebSecurity web) : Override this method to configure WebSecurity: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/WebSecurity.html
    // 3: protected void configure(AuthenticationManagerBuilder auth): Used by the default implementation of authenticationManager() to
    // attempt to obtain an AuthenticationManager
    // 4: protected UserDetailsService userDetailsService(): Deprecated.
    //Allows modifying and accessing the UserDetailsService from userDetailsServiceBean() without interacting with the ApplicationContext.
    // 5: UserDetailsService userDetailsServiceBean(): Override this method to expose a UserDetailsService created from configure(AuthenticationManagerBuilder) as a bean.
    // 6: protected AuthenticationManager authenticationManager(): Gets the AuthenticationManager to use.
    // 7: AuthenticationManager	authenticationManagerBean(): Override this method to expose the AuthenticationManager from configure(AuthenticationManagerBuilder) to be exposed as a Bean

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests().antMatchers("/index.html").permitAll();
        http.authorizeHttpRequests().antMatchers("/api/login/**", "/user/refresh_token/**").permitAll();
        http.authorizeHttpRequests().antMatchers("/user/**").permitAll();
        http.authorizeHttpRequests().antMatchers("/truyen/**").permitAll();
        http.authorizeHttpRequests().antMatchers("/permission/**").hasAnyRole("SUPER_ADMIN", "ADMIN");
        http.authorizeHttpRequests().antMatchers("/role/**").hasAnyRole("SUPER_ADMIN", "ADMIN");
        http.authorizeHttpRequests().antMatchers("/admin/**").hasAnyRole("SUPER_ADMIN", "ADMIN");
//        http.authorizeHttpRequests().antMatchers(HttpMethod.POST, "/api/user/saveRole/**").hasAuthority("ROLE_SUPER_ADMIN");
//        http.authorizeHttpRequests().antMatchers(HttpMethod.POST, "/api/user/saveRoleToUser/**").hasAuthority("ROLE_SUPER_ADMIN");
        http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
