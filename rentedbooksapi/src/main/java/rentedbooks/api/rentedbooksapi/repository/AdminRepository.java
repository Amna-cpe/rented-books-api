package rentedbooks.api.rentedbooksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rentedbooks.api.rentedbooksapi.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{

}
