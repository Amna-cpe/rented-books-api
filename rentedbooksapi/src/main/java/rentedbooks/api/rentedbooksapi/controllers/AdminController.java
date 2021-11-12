package rentedbooks.api.rentedbooksapi.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rentedbooks.api.rentedbooksapi.services.AdminService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	 @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody Map<String, String> json){
		 Long ID = Long.parseLong(json.get("id"));
		 adminService.Login(json.get("password"),ID);
	        return new ResponseEntity<String>("Logged in Succefully",HttpStatus.OK);
	    }
	 
	 @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody Map<String, String> json){
		 
		 Long ID = Long.parseLong(json.get("id"));
		 adminService.register(json.get("password"),ID);
	        return new ResponseEntity<String>("register in Succefully",HttpStatus.OK);
	    }

}
