package example.T1.repositories;

import org.springframework.data.repository.CrudRepository;
import example.T1.model.User;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 * This class is responsable for communication with the table in Database
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}

