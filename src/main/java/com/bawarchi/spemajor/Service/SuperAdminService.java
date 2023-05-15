package com.bawarchi.spemajor.Service;


import com.bawarchi.spemajor.Repository.SuperAdminRepository;
import com.bawarchi.spemajor.model.Role;
import com.bawarchi.spemajor.model.SuperAdmin;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminService {

    private SuperAdminRepository superAdminRepository;

    private SuperAuthService superAuthService;

    PasswordEncoder passwordEncoder;

    public SuperAdminService(SuperAdminRepository superAdminRepository, SuperAuthService superAuthService, PasswordEncoder passwordEncoder) {
        this.superAdminRepository = superAdminRepository;
        this.superAuthService = superAuthService;
        this.passwordEncoder = passwordEncoder;
    }

    public SuperAdmin addSuperAdmin(SuperAdmin superAdmin) throws RuntimeException {
        superAuthService.checkIfUserIdExists(superAdmin.getUsername());

        superAdmin.setPassword(passwordEncoder.encode(superAdmin.getPassword()));
        superAdmin.setRole(Role.ROLE_SUPER_ADMIN);
        return superAdminRepository.save(superAdmin);
    }


}
