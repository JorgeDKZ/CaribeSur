package com.caribe.sur.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import com.caribe.sur.enumerators.Role;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final String PATTERS_ADMIN = "/admin/**";
    private final String PATTERS_USER = "/user/**";
    private final String [] PATTERS_PERMITALL = {"/home", "/login", "/register", "adminLogin"};

    private final String HTML_LOGIN = "/login";

    private final String URL_LOGIN_SUCCESS = "/home";
    private final String URL_LOGOUT_SUCCESS = "/home";

     private final UserDetailsService userDetailsService;

    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configure the security, including user roles and access permissions 
        http.authorizeHttpRequests(auth -> auth
            .requestMatchers(PATTERS_ADMIN, PATTERS_USER).hasRole(Role.ADMIN.name())
            .requestMatchers(PATTERS_USER).hasRole(Role.USER.name())
            .requestMatchers(PATTERS_PERMITALL).permitAll()
            .anyRequest().authenticated())
            // Configure where to login and logout
            .formLogin(form -> form
                .loginPage(HTML_LOGIN)
                .failureUrl(HTML_LOGIN + "?error=true")
                .defaultSuccessUrl(URL_LOGIN_SUCCESS, true) 
                .permitAll())
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl(URL_LOGOUT_SUCCESS)
                .permitAll());

        


        return http.build();
     }

    
}
