package example.T1.repositories;

import example.T1.model.AdminUser;
import example.T1.model.PremiumUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * /**
 *  * This will be AUTO IMPLEMENTED by Spring into a Bean called adminUserRepository
 *  * CRUD refers Create, Read, Update, Delete
 *  * This class is responsable for communication with the table in Database
 *  */
@Repository
public interface AdminUserRepository extends CrudRepository<AdminUser, Integer> {
}
