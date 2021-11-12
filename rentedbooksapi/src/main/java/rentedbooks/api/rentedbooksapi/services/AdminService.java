package rentedbooks.api.rentedbooksapi.services;

import org.springframework.stereotype.Service;


public interface AdminService {
	
	

	public boolean Login(String password, Long Id);

	public void register(String password, Long id);

}
