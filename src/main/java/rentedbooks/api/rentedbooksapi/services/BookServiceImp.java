package rentedbooks.api.rentedbooksapi.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import rentedbooks.api.rentedbooksapi.model.Book;
import rentedbooks.api.rentedbooksapi.repository.BookRepository;

@Service
public class BookServiceImp implements BookService {
	
	public final String UPLOAD_DIR = new ClassPathResource("static/book-images/").getFile().getAbsolutePath();
	
	public BookServiceImp() throws IOException{}

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
		
	}

	@Override
	public void removeBook(long id) {		
		bookRepository.deleteById(id);		
	}

	@Override
	public ArrayList<Book> listBooks() {
		return (ArrayList<Book>) bookRepository.findAll();
		
	}

	@Override
	public void removeMultipleBook(long[] id) {
		// TODO Auto-generated method stub
		
	}


	
	@Override
	public void save_image(MultipartFile img) {
		
		try {
//			InputStream in = img.getInputStream();
//			byte[] data = new byte[in.available()];
//			
//			in.read(data);
//			
//			//write
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator + img.getOriginalFilename());
//			fos.write(in.read(data));
//			fos.flush();
//			fos.close();
			
			Files.copy(img.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + img.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
		}
		catch(Exception e){
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
		
	}


}
