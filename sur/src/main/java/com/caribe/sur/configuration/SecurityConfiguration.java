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
        private final String[] PATTERS_PERMITALL = { UrlFromPages.URL_HOME_PAGE, UrlFromPages.URL_LOGIN,
                        UrlFromPages.URL_REGISTER };

        private final String DELETECOOKIES = "JSESSIONID";

        private final UserDetailsService userDetailsService;

        public SecurityConfiguration(UserDetailsService userDetailsService) {
                this.userDetailsService = userDetailsService;
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                // Configure the security, including user roles and access permissions
                http.authorizeHttpRequests(auth -> auth
                                .requestMatchers(PATTERS_ADMIN).hasRole(Role.ADMIN.name())
                                .requestMatchers(PATTERS_USER).hasAnyRole(Role.USER.name(), Role.ADMIN.name())
                                .requestMatchers(PATTERS_PERMITALL).permitAll()
                                .anyRequest().permitAll())
                                // Configure where to login and logout
                                .formLogin(form -> form
                                                .loginPage(UrlFromPages.URL_LOGIN)
                                                .failureUrl(UrlFromPages.URL_LOGIN)
                                                .defaultSuccessUrl(UrlFromPages.URL_COMPROBE_IF_ADMIN, true)
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutUrl(UrlFromPages.URL_LOGOUT)
                                                .logoutSuccessUrl(UrlFromPages.URL_HOME_PAGE)
                                                .invalidateHttpSession(true)
                                                .deleteCookies(DELETECOOKIES)
                                                .clearAuthentication(true)
                                                .permitAll())
                                .exceptionHandling(ExceptionHandling -> ExceptionHandling
                                                .accessDeniedPage(UrlFromPages.URL_ERROR_ACCESS_DENIED));

                return http.build();
        }

}
