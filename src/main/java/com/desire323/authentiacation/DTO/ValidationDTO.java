package com.desire323.authentiacation.DTO;

public class ValidationDTO {
    private Long id;
    private String email;

    public ValidationDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public ValidationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
