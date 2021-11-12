package rentedbooks.api.rentedbooksapi.controllers;


import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import rentedbooks.api.rentedbooksapi.model.Book;
import rentedbooks.api.rentedbooksapi.services.BookService;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<ArrayList<Book>> get(){
		ArrayList<Book> books = bookService.listBooks();
		return new ResponseEntity<ArrayList<Book>>(books,HttpStatus.OK);		
	}
	
	@PostMapping("/add-book")
	public ResponseEntity<String> add(
			@RequestParam("image") MultipartFile image ,
			@RequestParam("name") String name,
			@RequestParam("id") Long id,
			@RequestParam("price") String price
			) {

		double prices = Double.valueOf(price);

		String message = "";
		try {
			 bookService.save_image(image);
			 String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		                .path("/book-images/")
		                .path(image.getOriginalFilename())
		                .toUriString();
			
			  String fileName = image.getOriginalFilename();
	          Book book = new Book();
	          book.setName(name);
	          book.setPrice(prices);
	          book.setId(id);	          
	          book.setImage(fileDownloadUri);
		      bookService.addBook(book);
		      
			message = "Uploaded the file successfully: " + image.getOriginalFilename();
			return new ResponseEntity<String>(message,HttpStatus.OK);
		} catch (Exception e) {
			message = "Could not upload the file: " + image.getOriginalFilename() + "!" + e.getMessage();
			return new ResponseEntity<String>(message,HttpStatus.EXPECTATION_FAILED);
		}

        
	}
	
	 @DeleteMapping("/books/{id}")
	    public ResponseEntity<String> delete(@PathVariable("id") Long id){
		 ;
		 bookService.removeBook(id);
	        return new ResponseEntity<String>("Deleted succefully",HttpStatus.OK);
	    }
}
