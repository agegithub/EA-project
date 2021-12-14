package com.example.eafinalproject.security.services;
import com.example.eafinalproject.model.Admin;
import com.example.eafinalproject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	public Admin save(Admin admin){
		return  adminRepository.save(admin);
	}
	public List<Admin> getAll(){
		return adminRepository.findAll();
	}
	public Admin getAdminById(String id){
		return adminRepository.getById(id);
	}
}