package example.T1.repositoryTest;

import example.T1.model.BaseUser;
import example.T1.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class UserRepositoryTest {

    @Mock
    UserRepository userRepository;

    /**
     * Testing repository for find an object
     */
    @Test
    public void findByIdBaseUserTest(){
        BaseUser user = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        user.setIdUser(1);
        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));

        BaseUser result = userRepository.findById(1).get();

        assertThat(result.getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Testing for getting all object from the table
     */
    @Test
    public void findAllUserTest(){
        BaseUser user = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        BaseUser user2 = new BaseUser("Stefan","stefan@gmail.com","dfhdshfjk","Strada Trecutului Nr 18",0);
        List<BaseUser> baseUserList = new ArrayList<>();
        baseUserList.add(user);
        baseUserList.add(user2);

        when(userRepository.findAll()).thenReturn(baseUserList);

        List<BaseUser> result = (List<BaseUser>)userRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(result.get(1).getUsername()).isEqualTo(user2.getUsername());
    }

    /**
     * Testing repository for delete an object
     */
    @Test
    public void deleteByIdBaseUserTest(){
        BaseUser user = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        user.setIdUser(1);
        userRepository.deleteById(1);

        Optional<BaseUser> result = userRepository.findById(1);

        assertThat(result.isEmpty()).isEqualTo(true);
    }

    /**
     * Testing for saving an object in the table
     */
    @Test
    public void saveBaseUserTest(){
        BaseUser user = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        user.setIdUser(1);
        when(userRepository.save(any())).thenReturn(user);

        BaseUser result = userRepository.save(user);

        assertThat(result.getUsername()).isEqualTo(user.getUsername());
    }
}
