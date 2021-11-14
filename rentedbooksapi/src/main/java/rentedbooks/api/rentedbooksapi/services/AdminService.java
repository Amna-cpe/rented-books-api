package rentedbooks.api.rentedbooksapi.services;

import rentedbooks.api.rentedbooksapi.model.Admin;

public interface AdminService {
	
	

	

	public void register(String password, String id);
	
	public Admin getAdmin();

}
