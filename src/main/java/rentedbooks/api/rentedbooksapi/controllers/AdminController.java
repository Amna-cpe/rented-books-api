package rentedbooks.api.rentedbooksapi.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rentedbooks.api.rentedbooksapi.model.Admin;
import rentedbooks.api.rentedbooksapi.model.AdminResponse;
import rentedbooks.api.rentedbooksapi.services.AdminService;
import rentedbooks.api.rentedbooksapi.services.MyUserDetailsService;
import rentedbooks.api.rentedbooksapi.utills.JwtUtill;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class AdminController {
	
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AdminService adminService;
	
	@Autowired 
	JwtUtill jwtUtill;
	
	@Autowired
	MyUserDetailsService myUserdetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//Accept ID AND PASSWROE
	// retunr jwt token
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> Authenticate(@RequestBody Admin admin) throws Exception {
System.out.println("the password is "+ admin.getPassword());
		try {
			
				authenticationManager.authenticate(	
					new UsernamePasswordAuthenticationToken(admin.getId() , admin.getPassword()));
		
			
			
		}
		catch(BadCredentialsException e) {
			throw new Exception("Incorrect Id or password",e);
		}
		
		// return the jwt if it successfull
		final UserDetails userDetails = myUserdetailsService.loadUserByUsername(admin.getId());
		final String jwt = jwtUtill.generateToken(userDetails);
		
		return ResponseEntity.ok(new AdminResponse(jwt));
		
	}
	
	
	 @PostMapping("/get")
	    public ResponseEntity<Admin> login(@RequestBody Map<String, String> json ){

		 
		 Admin admin = adminService.getAdmin();
		 System.out.print("the admin is"+admin);
		 return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	    }
//	 
	 @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody Map<String, String> json){
		 
		 String ID = json.get("id");
		 adminService.register(json.get("password"),ID);
	        return new ResponseEntity<String>("registered in Succefully",HttpStatus.OK);
	    }

}
