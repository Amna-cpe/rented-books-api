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
	public boolean Login(String password , Long Id) {
		// check if the password is the same as the one setting in the 
		Admin admin = adminRepo.findById(Id).get();
		return admin.getPassword().equals(password);
		
		
	}

	@Override
	public void register(String password, Long id) {
		Admin admin = new Admin();
		admin.setId(id);
		admin.setPassword(password);
		adminRepo.save(admin);
		
	}
	

}
