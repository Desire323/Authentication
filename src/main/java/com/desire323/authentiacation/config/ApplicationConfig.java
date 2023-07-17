package com.desire323.authentiacation.config;


import com.desire323.authentiacation.DTO.AuthenticationResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    private RestTemplate restTemplate;

    public ApplicationConfig() {
        this.restTemplate = new RestTemplate();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> (UserDetails) restTemplate.getForEntity(
                System.getenv("USER_SERVICE_URL") + "/email/" + username, AuthenticationResponse.class
        ).getBody();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}