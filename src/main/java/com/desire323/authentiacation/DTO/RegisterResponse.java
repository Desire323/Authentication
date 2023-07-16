package com.desire323.authentiacation.DTO;
public class RegisterResponse {
    private int id;
    private String email;

    public RegisterResponse(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public RegisterResponse() {
    }

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
}
