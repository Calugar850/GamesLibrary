package example.T1.repositoryTest;

import example.T1.model.PremiumUser;
import example.T1.repositories.PremiumUserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PremiumUserRepositoryTest {

    @Mock
    PremiumUserRepository premiumUserRepository;

    /**
     * Testing repository for find an object
     */
    @Test
    public void findByIdPremiumUserTest(){
        PremiumUser user = new PremiumUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        user.setIdUser(1);
        when(premiumUserRepository.findById(1)).thenReturn(java.util.Optional.of(user));

        PremiumUser result = premiumUserRepository.findById(1).get();

        assertThat(result.getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Testing for getting all object from the table
     */
    @Test
    public void findAllUserTest(){
        PremiumUser user = new PremiumUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        PremiumUser user2 = new PremiumUser("Stefan","stefan@gmail.com","dfhdshfjk","Strada Trecutului Nr 18",0);
        List<PremiumUser> premiumUsers = new ArrayList<>();
        premiumUsers.add(user);
        premiumUsers.add(user2);

        when(premiumUserRepository.findAll()).thenReturn(premiumUsers);

        List<PremiumUser> result = (List<PremiumUser>)premiumUserRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(result.get(1).getUsername()).isEqualTo(user2.getUsername());
    }

    /**
     * Testing repository for delete an object
     */
    @Test
    public void deleteByIdPremiumUserTest(){
        PremiumUser user = new PremiumUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        user.setIdUser(1);
        premiumUserRepository.deleteById(1);

        Optional<PremiumUser> result = premiumUserRepository.findById(1);

        assertThat(result.isEmpty()).isEqualTo(true);
    }

    /**
     * Testing for saving an object in the table
     */
    @Test
    public void saveBaseUserTest(){
        PremiumUser user = new PremiumUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        user.setIdUser(1);
        when(premiumUserRepository.save(any())).thenReturn(user);

        PremiumUser result = premiumUserRepository.save(user);

        assertThat(result.getUsername()).isEqualTo(user.getUsername());
    }
}
