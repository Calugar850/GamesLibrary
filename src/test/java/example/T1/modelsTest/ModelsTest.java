package example.T1.modelsTest;

import example.T1.model.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class ModelsTest {

    @Mock
    User user;

    /**
     * Testing for creating an object
     */
    @Test
    public void assertBaseUserTest(){
        UserFactory userFactory = new UserFactory("Andrei","andrei@gmail.com","sadkhsak","Strada Trecutului Nr 158", 0);
        user = userFactory.createUser(EnumUsers.BaseUser);
        BaseUser baseUser = new BaseUser("Andrei","andrei@gmail.com","sadkhsak","Strada Trecutului Nr 158", 0);
        assertEquals("Rezultatul: ", baseUser.getUsername(), user.getUsername());
        assertEquals("Rezultatul: ", baseUser.getEmail(), user.getEmail());
        assertEquals("Rezultatul: ", baseUser.getAdresa(), user.getAdresa());
        assertEquals("Rezultatul: ", baseUser.getParola(), user.getParola());
    }

    /**
     * Testing for creating an object
     */
	@Test
    public void assertPremiumTest(){
        UserFactory userFactory = new UserFactory("Andrei","andrei@gmail.com","sadkhsak","Strada Trecutului Nr 158", 0);
        user = userFactory.createUser(EnumUsers.BaseUser);
        PremiumUser baseUser = new PremiumUser("Andrei","andrei@gmail.com","sadkhsak","Strada Trecutului Nr 158", 0);
        assertEquals("Rezultatul: ", baseUser.getUsername(), user.getUsername());
        assertEquals("Rezultatul: ", baseUser.getEmail(), user.getEmail());
        assertEquals("Rezultatul: ", baseUser.getAdresa(), user.getAdresa());
        assertEquals("Rezultatul: ", baseUser.getParola(), user.getParola());
    }

    /**
     * Testing for creating an object
     */
    @Test
    public void assertAdminTest(){
        UserFactory userFactory = new UserFactory("Andrei","andrei@gmail.com","sadkhsak","Strada Trecutului Nr 158", 0);
        user = userFactory.createUser(EnumUsers.BaseUser);
        AdminUser baseUser = new AdminUser("Andrei","andrei@gmail.com","sadkhsak","Strada Trecutului Nr 158", 0);
        assertEquals("Rezultatul: ", baseUser.getUsername(), user.getUsername());
        assertEquals("Rezultatul: ", baseUser.getEmail(), user.getEmail());
        assertEquals("Rezultatul: ", baseUser.getAdresa(), user.getAdresa());
        assertEquals("Rezultatul: ", baseUser.getParola(), user.getParola());
    }

    /**
     * Testing for creating an object
     */
    @Test
    public void assertGameTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        assertEquals("Rezultatul: ",game.getNume(),"nume");
        assertEquals("Rezultatul: ",game.getAnAparitie(), 2000);
        assertEquals("Rezultatul: ",game.getPublisher(), "publisher");
        assertEquals("Rezultatul: ",game.getPret(), (float)20.0);
        assertEquals("Rezultatul: ",game.getGen(), "gen");
        assertEquals("Rezultatul: ",game.getDescriere(), "descriere");
    }

    /**
     * Testing for creating an object
     */
    @Test
    public void assertBillTest(){
        Bill bill = new Bill("Andrei","Str. Trecutului 35",20);
        assertEquals("Rezultatul: ",bill.getNume(),"Andrei");
        assertEquals("Rezultatul: ",bill.getAdresa(), "Str. Trecutului 35");
        assertEquals("Rezultatul: ",bill.getSuma(),(float)20.0);
    }

}
