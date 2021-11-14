package rentedbooks.api.rentedbooksapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Admin {

    @Id
    private String id;
    private String password;
    
}
