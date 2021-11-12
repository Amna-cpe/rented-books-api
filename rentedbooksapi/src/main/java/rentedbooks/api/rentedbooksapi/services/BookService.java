package rentedbooks.api.rentedbooksapi.services;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import rentedbooks.api.rentedbooksapi.model.Book;

public interface BookService {
	
	public void addBook(Book book);
	public void removeBook(long id);
	public void removeMultipleBook(long[] id);
	public ArrayList<Book> listBooks();
	public void save_image(MultipartFile image); 

}
