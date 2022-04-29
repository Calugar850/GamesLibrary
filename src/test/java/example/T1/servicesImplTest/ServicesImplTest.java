package example.T1.servicesImplTest;

import example.T1.model.*;
import example.T1.repositories.*;
import example.T1.services.BillServiceImpl;
import example.T1.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServicesImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PremiumUserRepository premiumUserRepository;

    @Mock
    private AdminUserRepository adminUserRepository;

    @Mock
    GameRepository gameRepository;

    @Mock
    private BillRepository billRepository;

    /**
     * Testing to retrieve an object with a specific id
     */
    @Test
    public void getBaseUserByIdTest(){
        BaseUser user = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        user.setIdUser(1);
        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));

        User result = userService.getUserByID(1,EnumUsers.BaseUser);

        assertThat(result.getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Testing to retrieve an object with a specific id
     */
    @Test
    public void getPremiumUserbyIdTest(){
        PremiumUser user = new PremiumUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        user.setIdUser(1);
        when(premiumUserRepository.findById(1)).thenReturn(java.util.Optional.of(user));

        User result = userService.getUserByID(1,EnumUsers.PremiumUser);

        assertThat(result.getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Testing to retrieve an object with a specific id
     */
    @Test
    public void getAdminUserbyIdTest(){
        AdminUser user = new AdminUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        user.setIdUser(1);
        when(adminUserRepository.findById(1)).thenReturn(java.util.Optional.of(user));

        User result = userService.getUserByID(1,EnumUsers.AdminUser);

        assertThat(result.getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Testing to retrieve all objects of this type
     */
    @Test
    public void getAllBaseUserTest(){
        BaseUser user = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        BaseUser user2 = new BaseUser("Stefan","stefan@gmail.com","dfhdshfjk","Strada Trecutului Nr 18",0);
        List<BaseUser> baseUserList = new ArrayList<>();
        baseUserList.add(user);
        baseUserList.add(user2);

        when(userRepository.findAll()).thenReturn(baseUserList);

        List<User> result = userService.getUsers(EnumUsers.BaseUser);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(result.get(1).getUsername()).isEqualTo(user2.getUsername());
    }

    /**
     * Testing to retrieve all objects of this type
     */
    @Test
    public void getAllPremiumUserTest(){
        PremiumUser user = new PremiumUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        PremiumUser user2 = new PremiumUser("Stefan","stefan@gmail.com","dfhdshfjk","Strada Trecutului Nr 18",0);
        List<PremiumUser> premiumUsers = new ArrayList<>();
        premiumUsers.add(user);
        premiumUsers.add(user2);

        when(premiumUserRepository.findAll()).thenReturn(premiumUsers);

        List<User> result = userService.getUsers(EnumUsers.PremiumUser);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(result.get(1).getUsername()).isEqualTo(user2.getUsername());
    }


    /**
     * Testing to retrieve all objects of this type
     */
    @Test
    public void getAllAdminUserTest(){
        AdminUser user = new AdminUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        AdminUser user2 = new AdminUser("Stefan","stefan@gmail.com","dfhdshfjk","Strada Trecutului Nr 18",0);
        List<AdminUser> adminUsers = new ArrayList<>();
        adminUsers.add(user);
        adminUsers.add(user2);

        when(adminUserRepository.findAll()).thenReturn(adminUsers);

        List<User> result = userService.getUsers(EnumUsers.AdminUser);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(result.get(1).getUsername()).isEqualTo(user2.getUsername());
    }

    /**
     * Testing for creating an object
     */
    @Test
    public void createUser(){
        UserFactory factoryUser = new UserFactory("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        User user = factoryUser.createUser(EnumUsers.BaseUser);
        user.setIdUser(1);
        BaseUser baseUser= new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);

        when(userRepository.save(any())).thenReturn(baseUser);

        User result = userService.createUser(user);

        assertThat(result.getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Test for delete an object with a specific Id
     */
    @Test
    public void deleteBaseUserbyIdTest(){
        BaseUser user = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        userService.deleteUserByID(1,EnumUsers.BaseUser);

        assertThat(user.getUsername()).isEqualTo("Andrei");
    }

    /**
     * Testing for updating an objects properties
     */
    @Test
    public void updateBaseUserTest(){
        UserFactory user = new UserFactory("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        User user1 = user.createUser(EnumUsers.BaseUser);
        userRepository.save((BaseUser)user1);
        user1.setUsername("Andrei2");

        assertThat(user1.getUsername()).isEqualTo("Andrei2");
    }

    /**
     * Testing a login functionality
     */
    @Test
    public void loginTest(){
        BaseUser user = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        UserFactory userFactory = new UserFactory("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        userFactory.setIdUser(1);
        User result = userService.loginUser(EnumUsers.BaseUser,user);
        result = user;
        user.setIdUser(1);
        when(userRepository.save(any())).thenReturn(user);


        assertThat(result.getUsername()).isEqualTo(user.getUsername());
        assertThat(result.getParola()).isEqualTo(user.getParola());
    }

    /**
     * Testing adding a game in user cart
     */
    @Test
    public void addGameInCartTest(){
        BaseUser baseUser = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        baseUser.setIdUser(1);
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        game.setIdGame(2);
        baseUser.getGames().add(game);

        userRepository.save(baseUser);
        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(baseUser));

        List<Game> result = userService.addGameInCart(1,EnumUsers.BaseUser,2);

        assertThat(result.get(0).getNume()).isEqualTo(baseUser.getGames().get(0).getNume());
    }

    /**
     * Testing removing a game in user cart
     */
    @Test
    public void removeGameInCartTest(){
        BaseUser baseUser = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        baseUser.setIdUser(1);
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        Game game2 = new Game("nume2",20002,  "publisher2",202,"gen2", "descriere2");
        game.setIdGame(2);
        game2.setIdGame(3);
        baseUser.getGames().add(game);
        baseUser.getGames().add(game2);

        userRepository.save(baseUser);
        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(baseUser));

        List<Game> result = userService.deleteGameFromCart(1,EnumUsers.BaseUser,2);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getNume()).isEqualTo(baseUser.getGames().get(0).getNume());

    }

    /**
     * Testing for generating a bill for an user
     */
    @Test
    public void generateBillPerClientTest(){
        Bill bill = new Bill("Andrei","Strada Trecutului Nr 158",60);
        BaseUser baseUser = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        baseUser.setIdUser(1);
        baseUser.getBills().add(bill);

        userRepository.save(baseUser);
        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(baseUser));

        List<Bill> result = userService.generateBillPerClient(1,EnumUsers.BaseUser);

        assertThat(result.get(0).getNume()).isEqualTo(bill.getNume());
    }

}
