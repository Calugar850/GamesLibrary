package example.T1.repositories;

import example.T1.data.ReadData;
import example.T1.model.User;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public interface UserRepositoryAvarie {
    public List<User> readFromFile();
    public void writeDataInFile(User user) throws IOException;
    public void writeUsersDataInFile(List<User> users) throws IOException;
    public void deleteUserInFile(User user) throws IOException;
    public void updateUserInFile(User user) throws IOException;
    public User findById(Integer id);
    public User createUser(User user);
    public void updateUser(Integer id, User user);
    public void deleteByID(Integer id);
}
