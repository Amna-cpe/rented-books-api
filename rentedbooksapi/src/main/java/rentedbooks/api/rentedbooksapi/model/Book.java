package rentedbooks.api.rentedbooksapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class Book {

    @Id
    private long id;
    private String name;
    private String image;
    private Double price;
}