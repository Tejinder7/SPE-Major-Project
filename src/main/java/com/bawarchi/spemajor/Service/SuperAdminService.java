package com.bawarchi.spemajor.Service;


import com.bawarchi.spemajor.Repository.FoodCourtRepository;
import com.bawarchi.spemajor.Repository.SuperAdminRepository;
import com.bawarchi.spemajor.model.FoodCourt;
import com.bawarchi.spemajor.model.Role;
import com.bawarchi.spemajor.model.SuperAdmin;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminService {

    private SuperAdminRepository superAdminRepository;

    public SuperAdminService(SuperAdminRepository superAdminRepository){
        this.superAdminRepository = superAdminRepository;
    }

    public SuperAdmin addSuperAdmin(SuperAdmin superAdminIn) throws RuntimeException {

        SuperAdmin superAdminOut = new SuperAdmin();

        superAdminOut.setUsername(superAdminIn.getUsername());
        superAdminOut.setPassword(superAdminIn.getPassword());
        superAdminOut.setRole(Role.ROLE_SUPER_ADMIN);

        superAdminOut = superAdminRepository.save(superAdminOut);

        return superAdminOut;
    }


}
