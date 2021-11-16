package rentedbooks.api.rentedbooksapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity
public class Admin {

    @Id
    private String id;
    private String password;
	public void setId(String id2) {
		id=id2;
		
	}
	public void setPassword(String encodedPassword) {
		// TODO Auto-generated method stub
		password=encodedPassword;
		
	}
	
	public String getId() {
		return id;
		
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
		
	}
    
}
