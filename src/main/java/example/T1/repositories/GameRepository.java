package example.T1.repositories;

import example.T1.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 * This class is responsable for communication with the table in Database
 */
@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
}
