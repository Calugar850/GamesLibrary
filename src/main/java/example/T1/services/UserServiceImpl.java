package example.T1.services;

import example.T1.data.ReadData;
import example.T1.model.*;
import example.T1.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * This class implement the logic for operation on user table from database
 */
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    PremiumUserRepository premiumUserRepository;
    AdminUserRepository adminUserRepository;
    GameRepository gameRepository;
    BillRepository billRepository;

    //UserRepositoryAvarie userRepositoryAvarie;

    /**
     *
     * //@param userRepository interface
     */
    public UserServiceImpl(UserRepository userRepository, PremiumUserRepository premiumUserRepository, AdminUserRepository adminUserRepository, GameRepository gameRepository, BillRepository billRepository) {
        this.userRepository = userRepository;
        this.premiumUserRepository = premiumUserRepository;
        this.adminUserRepository = adminUserRepository;
        this.gameRepository = gameRepository;
        this.billRepository = billRepository;
   }

    //public UserServiceImpl(UserRepositoryAvarie userRepositoryAvarie) {
    //    this.userRepositoryAvarie=userRepositoryAvarie;
    //}

    /**
     *
     * @return List users
     */
    @Override
    public List<User> getUsers(EnumUsers tip) {
        List<User> users = new ArrayList<>();
        if(tip==EnumUsers.BaseUser){
            List<BaseUser> baseUsers = new ArrayList<>();
            userRepository.findAll().forEach(baseUsers::add);
            for(BaseUser b: baseUsers){
                users.add(b);
            }
            return users;
        }else if(tip==EnumUsers.PremiumUser){
            List<PremiumUser> premiumUsers = new ArrayList<>();
            premiumUserRepository.findAll().forEach(premiumUsers::add);
            for(PremiumUser p: premiumUsers){
                users.add(p);
            }
            return users;
        }else if(tip==EnumUsers.AdminUser){
            List<AdminUser> adminUsers = new ArrayList<>();
            adminUserRepository.findAll().forEach(adminUsers::add);
            for(AdminUser a: adminUsers){
                users.add(a);
            }
            return users;
        }else{
            return null;
        }
        //List<User> users = new ArrayList<>();
        //userRepository.findAll().forEach(users::add);
        //return Collections.singletonList((User) users);
        //return userRepositoryAvarie.readFromFile();
    }

    /**
     *
     * @param id integer
     * @return User
     */
    @Override
    public User getUserByID(Integer id, EnumUsers tip) {
        if(tip==EnumUsers.BaseUser){
            return userRepository.findById(id).get();
        }else if(tip==EnumUsers.PremiumUser){
            return premiumUserRepository.findById(id).get();
        }else if(tip==EnumUsers.AdminUser){
            return adminUserRepository.findById(id).get();
        }
        return null;
       //return userRepositoryAvarie.findById(id);
    }

    /**
     *
     * @param user object
     * @return User
     */
    @Override
    public User createUser(User user) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(user.getParola().getBytes());
        String stringHash = new String(messageDigest.digest());
        user.setParola(stringHash);
        if(user.getTip()==0){
            return userRepository.save((BaseUser)user);
        }
        else if(user.getTip()==1){
            return premiumUserRepository.save((PremiumUser)user);
        }else if(user.getTip()==2){
            return adminUserRepository.save((AdminUser)user);
        }else{
            return null;
        }
        //return userRepositoryAvarie.createUser(user);
    }

    /**
     *
     * @param id integer
     * @param user object
     */
    @Override
    public void updateUser(Integer id, EnumUsers tip, User user) {
        if(tip==EnumUsers.BaseUser){
            BaseUser user1 = userRepository.findById(id).get();
            user1.setUsername(user.getUsername());
            user1.setEmail(user.getEmail());
            user1.setAdresa(user.getAdresa());
            userRepository.save(user1);
        }else if(tip==EnumUsers.PremiumUser){
            PremiumUser user2 = premiumUserRepository.findById(id).get();
            user2.setUsername(user.getUsername());
            user2.setEmail(user.getEmail());
            user2.setAdresa(user.getAdresa());
            premiumUserRepository.save(user2);
        }else if(tip==EnumUsers.AdminUser){
            AdminUser user3 = adminUserRepository.findById(id).get();
            user3.setUsername(user.getUsername());
            user3.setEmail(user.getEmail());
            user3.setAdresa(user.getAdresa());
            adminUserRepository.save(user3);
        }

        //userRepositoryAvarie.updateUser(id,user);
    }

    /**
     *
     * @param id integer
     */
    @Override
    public void deleteUserByID(Integer id, EnumUsers tip) {
        if(tip==EnumUsers.BaseUser){
            userRepository.deleteById(id);
        }else if(tip==EnumUsers.PremiumUser){
            premiumUserRepository.deleteById(id);
        }else if(tip==EnumUsers.AdminUser){
            adminUserRepository.deleteById(id);
        }
        //userRepositoryAvarie.deleteByID(id);
    }

    /**
     * This method is used to login a user in application
     * @param tip EnumUser
     * @param user UserFactoryUser
     * @return user
     */
    @Override
    public User loginUser(EnumUsers tip, User user){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(user.getParola().getBytes());
        String stringHash = new String(messageDigest.digest());
        User users;
        if(tip==EnumUsers.BaseUser) {
            List<BaseUser> baseUsers = new ArrayList<>();
            userRepository.findAll().forEach(baseUsers::add);
            for (BaseUser b : baseUsers) {
                if(b.getParola().equals(stringHash) && b.getUsername().equals(user.getUsername())){
                    users=b;
                    return users;
                }
            }
        }else if(tip==EnumUsers.PremiumUser){
            List<PremiumUser> premiumUsers = new ArrayList<>();
            premiumUserRepository.findAll().forEach(premiumUsers::add);
            for (PremiumUser p : premiumUsers) {
                if(p.getParola().equals(stringHash) && p.getUsername().equals(user.getUsername())){
                    users=p;
                    return users;
                }
            }
        }else if(tip==EnumUsers.AdminUser){
            List<AdminUser> adminUsers = new ArrayList<>();
            adminUserRepository.findAll().forEach(adminUsers::add);
            for (AdminUser a : adminUsers) {
                if(a.getParola().equals(stringHash) && a.getUsername().equals(user.getUsername())){
                    users=a;
                    return users;
                }
            }
        }
        return null;
    }

    /**
     * This method add a game in user cart and return the list of games from cart
     * @param id Integer
     * @param tip EnumUser
     * @param idGame Integer
     * @return games
     */
    @Override
    public List<Game> addGameInCart(Integer id, EnumUsers tip, Integer idGame){
        List<Game> games = (List<Game>) gameRepository.findAll();
        if(tip==EnumUsers.BaseUser){
            BaseUser user1 = userRepository.findById(id).get();
            for(Game g: games){
                if(g.getIdGame().equals(idGame)){
                    user1.getGames().add(g);
                }
            }
            user1.setGames(user1.getGames());
            userRepository.save(user1);
            return user1.getGames();
        }else if(tip==EnumUsers.PremiumUser){
            PremiumUser user2 = premiumUserRepository.findById(id).get();
            for(Game g: games){
                if(g.getIdGame().equals(idGame)){
                    user2.getGames().add(g);
                }
            }
            user2.setGames(user2.getGames());
            premiumUserRepository.save(user2);
            return  user2.getGames();
        }else if(tip==EnumUsers.AdminUser){
            AdminUser user3 = adminUserRepository.findById(id).get();
            for(Game g: games){
                if(g.getIdGame().equals(idGame)){
                    user3.getGames().add(g);
                }
            }
            user3.setGames(user3.getGames());
            adminUserRepository.save(user3);
            return user3.getGames();
        }
        return null;
    }

    /**
     * This method remove a game in user cart and return the list of games from cart
     * @param id Integer
     * @param tip EnumUser
     * @param idGame Integer
     * @return games
     */
    @Override
    public List<Game> deleteGameFromCart(Integer id, EnumUsers tip, Integer idGame){
        if(tip==EnumUsers.BaseUser){
            BaseUser user1 = userRepository.findById(id).get();
            user1.getGames().removeIf(g -> g.getIdGame().equals(idGame));
            user1.setGames(user1.getGames());
            userRepository.save(user1);
            return user1.getGames();
        }else if(tip==EnumUsers.PremiumUser){
            PremiumUser user2 = premiumUserRepository.findById(id).get();
            user2.getGames().removeIf(g -> g.getIdGame().equals(idGame));
            user2.setGames(user2.getGames());
            premiumUserRepository.save(user2);
            return  user2.getGames();
        }else if(tip==EnumUsers.AdminUser){
            AdminUser user3 = adminUserRepository.findById(id).get();
            user3.getGames().removeIf(g -> g.getIdGame().equals(idGame));
            user3.setGames(user3.getGames());
            adminUserRepository.save(user3);
            return user3.getGames();
        }
        return null;
    }

    /**
     * A method which generate a bill for an purchase of a client
     * @param idUser Integer
     * @param tip EnumUSer
     * @return bill
     */
    @Override
    public List<Bill> generateBillPerClient(Integer idUser, EnumUsers tip){
        List<Bill> bills = (List<Bill>) billRepository.findAll();
        if(tip==EnumUsers.BaseUser){
            BaseUser user1 = userRepository.findById(idUser).get();
            for(Bill b: bills){
                if(b.getNume().equals(user1.getUsername())){
                    user1.getBills().add(b);
                }
            }
            user1.setBills(user1.getBills());
            userRepository.save(user1);
            return user1.getBills();
        }else if(tip==EnumUsers.PremiumUser){
            PremiumUser user2 = premiumUserRepository.findById(idUser).get();
            for(Bill b: bills){
                if(b.getNume().equals(user2.getUsername())){
                    user2.getBills().add(b);
                }
            }
            user2.setGames(user2.getGames());
            premiumUserRepository.save(user2);
            return user2.getBills();
        }else if(tip==EnumUsers.AdminUser){
            AdminUser user3 = adminUserRepository.findById(idUser).get();
            for(Bill b: bills){
                if(b.getNume().equals(user3.getUsername())){
                    user3.getBills().add(b);
                }
            }
            user3.setGames(user3.getGames());
            adminUserRepository.save(user3);
            return user3.getBills();
        }
        return null;
    }

}
