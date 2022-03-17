package example.T1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import example.T1.model.Game;

/**
 * This class is user model for Database
 */
@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idUser;
    private String username;
    private String email;
    private String parola;
    private String adresa;
    private int tip;

    @OneToMany
    private List<Game> games=new ArrayList<>();

    /**
     *
     * @param username string
     * @param email string
     * @param parola string
     * @param adresa string
     * @param tip int
     */
    public User(String username, String email, String parola, String adresa, int tip) {
        this.username = username;
        this.email = email;
        this.parola = parola;
        this.adresa = adresa;
        this.tip = tip;
    }

    /**
     * @return Integer
     */
    public Integer getIdUser() {
        return idUser;
    }

    /**
     *
     * @param idUser integer
     */

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    /**
     *
     * @return String
     */

    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username string
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return String
     */

    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email string
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return String
     */
    public String getParola() {
        return parola;
    }

    /**
     *
     * @param parola string
     */
    public void setParola(String parola) {
        this.parola = parola;
    }

    /**
     *
     * @return String
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     *
     * @param adresa string
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     *
     * @return int
     */
    public int isTip() {
        return tip;
    }

    /**
     *
     * @param tip int
     */
    public void setTip(int tip) {
        this.tip = tip;
    }

    /**
     *
     * @return int
     */
    public int getTip() {
        return tip;
    }

    /**
     *
     * @return List games
     */
    public List<Game> getGames() {
        return games;
    }

    /**
     *
     * @param games object
     */
    public void setGames(List<Game> games) {
        this.games = games;
    }

    /**
     * default constructor
     */
    public User() {
    }
}

