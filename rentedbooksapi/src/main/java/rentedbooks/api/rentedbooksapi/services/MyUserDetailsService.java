package rentedbooks.api.rentedbooksapi.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rentedbooks.api.rentedbooksapi.model.Admin;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired 
	AdminService adminService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// return a user from DB
		Admin admin = adminService.getAdmin();
		System.out.println("the username is "+admin.getId());
		// you will need to uncrypt the password if so
		return new User(admin.getId() , admin.getPassword() , (Collection<? extends GrantedAuthority>) new ArrayList<Object>());

	}

}
