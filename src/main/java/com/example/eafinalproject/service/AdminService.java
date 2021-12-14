package com.example.eafinalproject.service;

import com.example.eafinalproject.model.Admin;
import com.example.eafinalproject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class AdminService {
    @Autowired
    AdminRepository adminRepository;
    public Admin save(Admin admin){
        return  adminRepository.save(admin);
    }
    public List<Admin> getAll(){
        return (List<Admin>) adminRepository.findAll();
    }
    public Admin getAdminById(String id){
        Optional<Admin> admins = adminRepository.findById(id);
        if(admins.isPresent()){
            return admins.get();
        }
          return null;
}
public Admin updateAdmins (Admin admin, String id) {
    Optional<Admin> existingAdmin = adminRepository.findById(id);
    if (existingAdmin.isPresent()) {
        return
    }








