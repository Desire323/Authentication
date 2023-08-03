package com.desire323.authentiacation.service;

import com.desire323.authentiacation.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {


    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationProvider authenticationProvider;
    private final RestTemplate restTemplate;

    @Autowired
    public AuthenticationService(PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 AuthenticationProvider authenticationProvider,
                                 RestTemplate restTemplate) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationProvider = authenticationProvider;
        this.restTemplate = restTemplate;
    }
    private String baseUrl = System.getenv("USER_SERVICE_URL");

    public String register(RegisterRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        ResponseEntity<RegisterResponse> responseEntity = restTemplate.postForEntity(baseUrl, request, RegisterResponse.class);
        RegisterResponse response = responseEntity.getBody();
        Long id = response.getId();
        String email = response.getEmail();

        return generateJwt(id, email);
    }

    public LoginResponse authenticate(AuthenticationDTO request) {
        String url = baseUrl + "/email/" + request.getEmail();
        ResponseEntity<AuthenticationResponse> responseEntity = restTemplate.getForEntity (url, AuthenticationResponse.class);
        AuthenticationResponse response = responseEntity.getBody();

        if(!passwordEncoder.matches(request.getPassword(), response.getPassword())) {
            throw new RuntimeException("Invalid password");
        }


        Collection<? extends GrantedAuthority> authorities = response.getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        new UsernamePasswordAuthenticationToken(
                response.getEmail(),
                response.getPassword(),
                authorities
        );
        String jwt =  generateJwt(response.getId(), response.getEmail());
        return new LoginResponse(response.getFirstname(), response.getLastname(), jwt);
    }

    public Optional<ValidationDTO> validateToken(String token){
        String url = baseUrl + "/email/" + jwtService.extractUsername(token);
        ResponseEntity<AuthenticationResponse> responseEntity = restTemplate.getForEntity (url, AuthenticationResponse.class);
        AuthenticationResponse response = responseEntity.getBody();
        ValidationDTO validationDTO = new ValidationDTO(response.getId(), response.getEmail());

        if (!jwtService.isTokenValid(token, response.getEmail())){
            return Optional.empty();
        }
        return Optional.of(validationDTO);
    }

    public String generateJwt(Long id, String email){
        Map<String, Object> extraClaim = new HashMap<>();
        extraClaim.put("id", id);
        String jwtToken = jwtService.generateToken(extraClaim, email);
        return jwtToken;
    }
}