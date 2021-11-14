package rentedbooks.api.rentedbooksapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rentedbooks.api.rentedbooksapi.model.Admin;
import rentedbooks.api.rentedbooksapi.repository.AdminRepository;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired
	AdminRepository adminRepo;


	@Override
	public void register(String password, String id) {
		Admin admin = new Admin();
		admin.setId(id);
		// the password must be hashed first
		admin.setPassword(password);
		adminRepo.save(admin);		
	}

	@Override
	public Admin getAdmin() {
		// TODO Auto-generated method stub
		Admin admin = adminRepo.findAll().get(0);
		return admin;
	}
	

}
