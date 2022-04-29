package example.T1.repositoryTest;


import example.T1.model.AdminUser;
import example.T1.repositories.AdminUserRepository;
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
public class AdminUserRepositoryTest {

    @Mock
    AdminUserRepository adminUserRepository;

    /**
     * Testing repository for find an object
     */
    @Test
    public void findByIdAdminUserTest(){
        AdminUser user = new AdminUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        user.setIdUser(1);
        when(adminUserRepository.findById(1)).thenReturn(java.util.Optional.of(user));

        AdminUser result = adminUserRepository.findById(1).get();

        assertThat(result.getUsername()).isEqualTo(user.getUsername());
    }

    /**
     * Testing for getting all object from the table
     */
    @Test
    public void findAllUserTest(){
        AdminUser user = new AdminUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        AdminUser user2 = new AdminUser("Stefan","stefan@gmail.com","dfhdshfjk","Strada Trecutului Nr 18",0);
        List<AdminUser> adminUsers = new ArrayList<>();
        adminUsers.add(user);
        adminUsers.add(user2);

        when(adminUserRepository.findAll()).thenReturn(adminUsers);

        List<AdminUser> result = (List<AdminUser>)adminUserRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(result.get(1).getUsername()).isEqualTo(user2.getUsername());
    }

    /**
     * Testing repository for delete an object
     */
    @Test
    public void deleteByIdAdminUserTest(){
        AdminUser user = new AdminUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        user.setIdUser(1);
        adminUserRepository.deleteById(1);

        Optional<AdminUser> result = adminUserRepository.findById(1);

        assertThat(result.isEmpty()).isEqualTo(true);
    }

    /**
     * Testing for saving an object in the table
     */
    @Test
    public void saveAdminUserTest(){
        AdminUser user = new AdminUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului Nr 158",0);
        user.setIdUser(1);
        when(adminUserRepository.save(any())).thenReturn(user);

        AdminUser result = adminUserRepository.save(user);

        assertThat(result.getUsername()).isEqualTo(user.getUsername());
    }
}
