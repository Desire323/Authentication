package com.desire323.authentiacation.DTO;

public class LoginResponse {
    private String firstname;
    private String lastname;
    private String jwt;

    public LoginResponse(String firstname, String lastname, String jwt) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.jwt = jwt;
    }

    public LoginResponse() {
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

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}

