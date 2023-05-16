package com.bawarchi.spemajor.Security.Auth;

import com.bawarchi.spemajor.Exception.ForbiddenException;
import com.bawarchi.spemajor.Exception.ResourceNotFoundException;
import com.bawarchi.spemajor.Repository.SuperAuthRepository;
import com.bawarchi.spemajor.Security.Configuration.JwtService;
import com.bawarchi.spemajor.model.SuperAuth;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final SuperAuthRepository superAuthRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(SuperAuthRepository superAuthRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.superAuthRepository = superAuthRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public JwtResponse authenticate(SuperAuth request) {
        try{
            System.out.println(request.getUsername());
            System.out.println(request.getPassword());
            System.out.println(request.getRole());
            System.out.println(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch(Exception exception){
            throw new ForbiddenException("Invalid Credentials. Please try again with valid credentials");
        }

        SuperAuth user = superAuthRepository.findByUsername(request.getUsername())
                .orElseThrow();

        if(user.getRole() != request.getRole()){
            throw new ResourceNotFoundException("Invalid Role. Please try again with valid credentials");
        }

        var jwtToken = jwtService.createToken(user);

        return new JwtResponse(jwtToken, user.getAuthId());
    }

}
