package example.T1.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import example.T1.model.User;
import example.T1.repositories.UserRepositoryAvarie;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ReadData implements UserRepositoryAvarie {
    List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public ReadData(List<User> users) {
        this.users = users;
    }

    public ReadData(){}

    public List<User> readFromFile(){
        ObjectMapper objectMapper = new ObjectMapper();

        File jsonFile= new File("src/main/java/example/T1/useri.json");
        try {
            users = objectMapper.readValue(jsonFile, new TypeReference<List<User>>() {});
            return users;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeDataInFile(User user) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Path path = Paths.get("src/main/java/example/T1/useri.json");
        final String currentJsonArrayAsString = Files.readString(path);

        try (FileWriter fileWriter = new FileWriter(path.toFile(), false)) {

            JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(user));
            JSONArray jsonArray = new JSONArray(currentJsonArrayAsString);
            jsonArray.put(jsonObject);

            fileWriter.write(jsonArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void writeUsersDataInFile(List<User> users) throws IOException {
        JSONArray userList = new JSONArray();
        for(User u:users){
            JSONObject userObject = new JSONObject();
            try {
                userObject.put("idUser", u.getIdUser());
                userObject.put("username", u.getUsername());
                userObject.put("email", u.getEmail());
                userObject.put("parola", u.getParola());
                userObject.put("adresa", u.getAdresa());
                userObject.put("tip", u.getTip());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            userList.put(userObject);
        }
        try (FileWriter file = new FileWriter("src/main/java/example/T1/useri.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(userList.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserInFile(User user) throws IOException {
        List<User> users= readFromFile();
        for(User u:users){
            if(u.getIdUser().equals(user.getIdUser())){
                users.remove(u);
                break;
            }
        }
        writeUsersDataInFile(users);
    }


    public void updateUserInFile(User user) throws IOException {
        List<User> users= readFromFile();
        for(User u:users){
            if(u.getIdUser().equals(user.getIdUser())){
                u.setUsername(user.getUsername());
                u.setEmail(user.getEmail());
                u.setAdresa(user.getAdresa());
                break;
            }
        }
        writeUsersDataInFile(users);
    }

    public User findById(Integer id){
        users=readFromFile();
        for(User u: users){
            if(u.getIdUser().equals(id)){
                return u;
            }
        }
        return null;
    }

    public User createUser(User user){
        try {
            writeDataInFile(user);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    public void updateUser(Integer id, User user){
        users=readFromFile();
        for(User u: users){
            if(u.getIdUser().equals(id)){
                u.setUsername(user.getUsername());
                u.setEmail(user.getEmail());
                u.setAdresa(user.getAdresa());
                try {
                    updateUserInFile(u);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public void deleteByID(Integer id){
        users=readFromFile();
        for(User u: users){
            if(u.getIdUser().equals(id)){
                try {
                    deleteUserInFile(u);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
