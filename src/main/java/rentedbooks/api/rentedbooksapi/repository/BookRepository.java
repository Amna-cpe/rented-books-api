
package rentedbooks.api.rentedbooksapi.repository;

import rentedbooks.api.rentedbooksapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}