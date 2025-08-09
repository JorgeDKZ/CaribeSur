package com.caribe.sur.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import com.caribe.sur.enumerators.Role;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final String PATTERS_ADMIN = "/admin/**";
    private final String PATTERS_USER = "/user/**";
    private final String [] PATTERS_PERMITALL = {UrlFromPages.URL_HOME_PAGE, UrlFromPages.URL_LOGIN, UrlFromPages.URL_REGISTER};

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
            .anyRequest().permitAll())
            // Configure where to login and logout
            .formLogin(form -> form
                .loginPage(UrlFromPages.URL_LOGIN)
                .failureUrl(UrlFromPages.URL_LOGIN + "?error=true")
                .defaultSuccessUrl(UrlFromPages.URL_USER_HOME, true) 
                .permitAll())
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl(UrlFromPages.URL_HOME_PAGE)
                .permitAll());

        


        return http.build();
     }

    
}
