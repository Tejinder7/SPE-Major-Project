package com.bawarchi.spemajor.Service;

import com.bawarchi.spemajor.Exception.ForbiddenException;
import com.bawarchi.spemajor.Repository.SuperAuthRepository;
import com.bawarchi.spemajor.model.SuperAuth;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperAuthService {

    private SuperAuthRepository superAuthRepository;

    public SuperAuthService(SuperAuthRepository superAuthRepository){
        this.superAuthRepository = superAuthRepository;
    }

    public SuperAuth loginCheck(String username, String password, String role) throws RuntimeException{
        Optional<SuperAuth> superAuth = superAuthRepository.findByUsername(username);

        if(superAuth.get().getRole().toString().equals(role) && superAuth.get().getPassword().equals(password)){
            return superAuth.get();
        }else {
            System.out.println("SuperAuth Login Failed");
            throw new RuntimeException();
        }
    }

    public void checkIfUserIdExists(String username){
//        validationHelper.usernamePasswordValidation(username);
        Optional<SuperAuth> authorization = superAuthRepository.findByUsername(username);

        if(authorization.isPresent()){
            throw new ForbiddenException("User already exists. Please try again with a different User id");
        }
    }

}
