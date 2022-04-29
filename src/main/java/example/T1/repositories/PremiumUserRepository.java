package example.T1.repositories;

import example.T1.model.BaseUser;
import example.T1.model.PremiumUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * /**
 *  * This will be AUTO IMPLEMENTED by Spring into a Bean called premiumUserRepository
 *  * CRUD refers Create, Read, Update, Delete
 *  * This class is responsable for communication with the table in Database
 */
@Repository
public interface PremiumUserRepository extends CrudRepository<PremiumUser, Integer> {
}
