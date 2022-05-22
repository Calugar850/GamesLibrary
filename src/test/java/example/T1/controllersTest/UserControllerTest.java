package example.T1.controllersTest;
import example.T1.controllers.UserController;
import example.T1.model.*;
import example.T1.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    /**
     * Test to get all objects
     */
    @Test
    public void getAllBaseUsersTest(){
        BaseUser user = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        BaseUser user2 = new BaseUser("Stefan","stefan@gmail.com","dfhdshfjk","Strada Trecutului Nr 18",0);
        List<User> baseUserList = new ArrayList<>();
        baseUserList.add(user);
        baseUserList.add(user2);

        when(userService.getUsers(EnumUsers.BaseUser)).thenReturn(baseUserList);

        ResponseEntity<List<User>> result = userController.getAllUsers(EnumUsers.BaseUser);

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(result.getBody().get(1).getUsername()).isEqualTo(user2.getUsername());
    }

    /**
     * Test to get all objects
     */
    @Test
    public void getAllPremiumUsersTest(){
        PremiumUser user = new PremiumUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        PremiumUser user2 = new PremiumUser("Stefan","stefan@gmail.com","dfhdshfjk","Strada Trecutului Nr 18",0);
        List<User> baseUserList = new ArrayList<>();
        baseUserList.add(user);
        baseUserList.add(user2);

        when(userService.getUsers(EnumUsers.PremiumUser)).thenReturn(baseUserList);

        ResponseEntity<List<User>> result = userController.getAllUsers(EnumUsers.PremiumUser);

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(result.getBody().get(1).getUsername()).isEqualTo(user2.getUsername());
    }

    /**
     * Test to get all objects
     */
    @Test
    public void getAllAdminUsersTest(){
        AdminUser user = new AdminUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        AdminUser user2 = new AdminUser("Stefan","stefan@gmail.com","dfhdshfjk","Strada Trecutului Nr 18",0);
        List<User> baseUserList = new ArrayList<>();
        baseUserList.add(user);
        baseUserList.add(user2);

        when(userService.getUsers(EnumUsers.AdminUser)).thenReturn(baseUserList);

        ResponseEntity<List<User>> result = userController.getAllUsers(EnumUsers.AdminUser);

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(result.getBody().get(1).getUsername()).isEqualTo(user2.getUsername());
    }

    /**
     * Test for get a single object by id of item
     */
    @Test
    public void getBaseUserbyIdTest(){
        BaseUser user = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);

        when(userService.getUserByID(1)).thenReturn(user);

        ResponseEntity<User> result = userController.getUserByID(1);

        assertThat(result.getBody().getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Test for get a single object by id of item
     */
    @Test
    public void getPremiumUserbyIdTest(){
        PremiumUser user = new PremiumUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);

        when(userService.getUserByID(1)).thenReturn(user);

        ResponseEntity<User> result = userController.getUserByID(1);

        assertThat(result.getBody().getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Test for get a single object by id of item
     */
    @Test
    public void getAdminUserbyIdTest(){
        AdminUser user = new AdminUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);

        when(userService.getUserByID(1)).thenReturn(user);

        ResponseEntity<User> result = userController.getUserByID(1);

        assertThat(result.getBody().getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Test of creating an object
     */
    @Test
    public void createUserTest(){
        UserFactory factoryUser = new UserFactory("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        User user = factoryUser.createUser(EnumUsers.BaseUser);
        BaseUser baseUser= new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        baseUser.setIdUser(1);
        when(userService.createUser(any())).thenReturn(baseUser);

        ResponseEntity<User> result = userController.createUser(EnumUsers.BaseUser,factoryUser);

        assertThat(result.getBody().getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Test of creating an object
     */
    @Test
    public void createPremiumUserTest(){
        UserFactory factoryUser = new UserFactory("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        User user = factoryUser.createUser(EnumUsers.BaseUser);
        PremiumUser premiumUser = new PremiumUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        premiumUser.setIdUser(1);
        when(userService.createUser(any())).thenReturn(premiumUser);

        ResponseEntity<User> result = userController.createUser(EnumUsers.PremiumUser,factoryUser);

        assertThat(result.getBody().getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Test of creating an object
     */
    @Test
    public void createAdminUserTest(){
        UserFactory factoryUser = new UserFactory("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        User user = factoryUser.createUser(EnumUsers.BaseUser);
        AdminUser adminUser = new AdminUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        adminUser.setIdUser(1);
        when(userService.createUser(any())).thenReturn(adminUser);

        ResponseEntity<User> result = userController.createUser(EnumUsers.AdminUser,factoryUser);

        assertThat(result.getBody().getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Testing for delete an object by id of object
     */
    @Test
    public void deleteBaseUserbyIdTest(){
        BaseUser user = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        userService.deleteUserByID(1,EnumUsers.BaseUser);
        ResponseEntity<User> result = userController.deleteUserByID(1,EnumUsers.BaseUser);

        assertThat(result.getStatusCode().toString()).isEqualTo("204 NO_CONTENT");
    }

    /**
     * Testing for delete an object by id of object
     */
    @Test
    public void deletePremiumUserbyIdTest(){
        PremiumUser user = new PremiumUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        userService.deleteUserByID(1,EnumUsers.PremiumUser);
        ResponseEntity<User> result = userController.deleteUserByID(1,EnumUsers.PremiumUser);

        assertThat(result.getStatusCode().toString()).isEqualTo("204 NO_CONTENT");
    }

    /**
     * Testing for delete an object by id of object
     */
    @Test
    public void deleteAdminUserbyIdTest(){
        AdminUser user = new AdminUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        userService.deleteUserByID(1,EnumUsers.AdminUser);
        ResponseEntity<User> result = userController.deleteUserByID(1,EnumUsers.AdminUser);

        assertThat(result.getStatusCode().toString()).isEqualTo("204 NO_CONTENT");
    }

    /**
     * Test for update an object properties
     */
    @Test
    public void updateBaseUserTest(){
        UserFactory user = new UserFactory("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        User user1 = user.createUser(EnumUsers.BaseUser);
        userService.updateUser(1,EnumUsers.BaseUser,user1);

        ResponseEntity<User> result = userController.updateUser(1,EnumUsers.BaseUser,user);

        assertThat(result.getStatusCode().toString()).isEqualTo("200 OK");
    }

    /**
     * Testing login functionality
     */
    @Test
    public void loginUser(){
        BaseUser user = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        UserFactory userFactory = new UserFactory("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        userFactory.setIdUser(1);
        user.setIdUser(1);
        when(userService.loginUser(EnumUsers.BaseUser,user)).thenReturn(user);

        User result = userService.loginUser(EnumUsers.BaseUser,user);

        assertThat(result.getUsername()).isEqualTo(user.getUsername());
        assertThat(result.getParola()).isEqualTo(user.getParola());
    }

    /**
     * Testing adding a game in a user cart
     */
    @Test
    public void addGameInCartTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        List<Game> games = new ArrayList<>();
        games.add(game);
        when(userService.addGameInCart(1,EnumUsers.BaseUser,2)).thenReturn(games);

        ResponseEntity<List<Game>> result = userController.addGameInCart(1,EnumUsers.BaseUser,2);

        assertThat(result.getBody().get(0).getNume()).isEqualTo(game.getNume());
    }

    /**
     * Testing removing a game in a user cart
     */
    @Test
    public void removeGameInCartTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        List<Game> games = new ArrayList<>();
        games.add(game);

        when(userService.deleteGameFromCart(1,EnumUsers.BaseUser,2)).thenReturn(games);

        ResponseEntity<List<Game>> result = userController.deleteUserByID(1,EnumUsers.BaseUser,2);

        assertThat(result.getStatusCode().toString()).isEqualTo("204 NO_CONTENT");
    }

    /**
     * Testing for generating a bill for a user
     */
    @Test
    public void generateBillPerClientTest(){
        Bill bill = new Bill("Andrei","Strada Trecutului Nr 158",60);
        List<Bill> bills = new ArrayList<>();
        bills.add(bill);
        when(userService.generateBillPerClient(1,EnumUsers.BaseUser)).thenReturn(bills);

        ResponseEntity<List<Bill>> result = userController.generateBillPerClient(1,EnumUsers.BaseUser);

        assertThat(result.getBody().get(0).getNume()).isEqualTo(bill.getNume());
    }

}
