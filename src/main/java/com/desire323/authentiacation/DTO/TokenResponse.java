package com.desire323.authentiacation.DTO;

import java.util.Objects;

@Deprecated
public class TokenResponse {
    private String token;

    public TokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TokenResponse that = (TokenResponse) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "token='" + token + '\'' +
                '}';
    }

    public static class Builder {
        private String token;

        public Builder setToken(String token) {
            this.token = token;
            return this;
        }

        public TokenResponse build() {
            return new TokenResponse(token);
        }
    }
}
