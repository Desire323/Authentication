package com.desire323.authentiacation.DTO;


import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

public class AuthenticationResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private List<String> authorities;

    public AuthenticationResponse(UserDetails userDetails) {
    }

    public AuthenticationResponse() {
    }
    public AuthenticationResponse(Long id, String firstname, String lastname, String email,
                                  String password, List<String> authorities) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
