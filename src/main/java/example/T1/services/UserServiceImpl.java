package example.T1.services;

import example.T1.model.User;
import example.T1.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implement the logic for operation on user table from database
 */
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    /**
     *
     * @param userRepository interface
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     *
     * @return List users
     */
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    /**
     *
     * @param id integer
     * @return User
     */
    @Override
    public User getUserByID(Integer id) {
        return userRepository.findById(id).get();
    }

    /**
     *
     * @param user object
     * @return User
     */
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     *
     * @param id integer
     * @param user object
     */
    @Override
    public void updateUser(Integer id, User user) {
        User user1 = userRepository.findById(id).get();
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setAdresa(user.getAdresa());
        userRepository.save(user1);
    }

    /**
     *
     * @param id integer
     */
    @Override
    public void deleteUserByID(Integer id) {
        userRepository.deleteById(id);
    }
}
