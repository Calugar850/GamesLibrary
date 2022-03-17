package example.T1.services;

import example.T1.model.User;

import java.util.List;
/**
 * Is an interface for declaration of methods which will applied for user table
 */
public interface UserService {
    /**
     *
     * @return  List users
     */
    List<User> getUsers();
    /**
     *
     * @param id integer
     * @return User
     */
    User getUserByID(Integer id);
    /**
     *
     * @param user object
     * @return User
     */
    User createUser(User user);
    /**
     *
     * @param id integer
     * @param user object
     */
    void updateUser(Integer id, User user);
    /**
     *
     * @param id integer
     */
    void deleteUserByID(Integer id);
}
