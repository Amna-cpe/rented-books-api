package rentedbooks.api.rentedbooksapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rentedbooks.api.rentedbooksapi.model.Admin;
import rentedbooks.api.rentedbooksapi.repository.AdminRepository;

@Service
public class AdminServiceImp implements AdminService {

	PasswordEncoder passwordEncoder;
	
	@Autowired
	AdminRepository adminRepo;


	@Override
	public void register(String password, String id) {
		passwordEncoder = new BCryptPasswordEncoder();
		Admin admin = new Admin();
		String encodedPassword = passwordEncoder.encode(password);
		admin.setId(id);
		// the password must be hashed first
		admin.setPassword(encodedPassword);
		adminRepo.save(admin);		
	}

	@Override
	public Admin getAdmin() {
		
		// TODO Auto-generated method stub
		Admin admin = adminRepo.findAll().get(0);
		return admin;
	}
	

}
