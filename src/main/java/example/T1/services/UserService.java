package example.T1.services;

import example.T1.model.*;

import java.util.List;
/**
 * Is an interface for declaration of methods which will applied for user table
 */
public interface UserService {
    /**
     *
     * @return  List users
     */
    List<User> getUsers(EnumUsers tip);

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
    void updateUser(Integer id, EnumUsers tip, User user);

    /**
     *
     * @param id integer
     */
    void deleteUserByID(Integer id, EnumUsers tip);

    /**
     * This method is used to login a user in application
     * @param tip EnumUser
     * @param user UserFactoryUser
     * @return user
     */
    User loginUser(EnumUsers tip, User user);

    /**
     * This method add a game in user cart and return the list of games from cart
     * @param id Integer
     * @param tip EnumUser
     * @param idGame Integer
     * @return games
     */
    List<Game> addGameInCart(Integer id, EnumUsers tip, Integer idGame);

    /**
     * This method remove a game in user cart and return the list of games from cart
     * @param id Integer
     * @param tip EnumUser
     * @param idGame Integer
     * @return games
     */
    List<Game> deleteGameFromCart(Integer id, EnumUsers tip, Integer idGame);

    /**
     * A method which generate a bill for an purchase of a client
     * @param idUser Integer
     * @param tip EnumUSer
     * @return bill
     */
    List<Bill> generateBillPerClient(Integer idUser, EnumUsers tip);

}
