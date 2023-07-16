package com.desire323.authentiacation.DTO;


import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

public class AuthenticationResponse {
    private int id;
    private String email;
    private String password;
    private List<String> authorities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}
