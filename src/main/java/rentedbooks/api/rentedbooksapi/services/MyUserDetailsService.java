package rentedbooks.api.rentedbooksapi.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

		// you will need to uncrypt the password if so
//		return new User(admin.getId() , admin.getPassword() , (Collection<? extends GrantedAuthority>) new ArrayList<Object>());

		return new UserDetails() {

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				
				return AuthorityUtils.createAuthorityList("admin");
			}

			@Override
			public String getPassword() {			
				return admin.getPassword();
			}

			@Override
			public String getUsername() {			
				return admin.getId();
			}

			@Override
			public boolean isAccountNonExpired() {			
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {				
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {			
				return true;
			}

			@Override
			public boolean isEnabled() {			
				return true;
			}
			
		};
		
		
	}
	

}
