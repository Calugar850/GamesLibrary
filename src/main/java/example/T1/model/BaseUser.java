package example.T1.model;

import example.T1.FactoryPattern.Angajat;
import org.hibernate.usertype.UserType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This Class is a Table in database and is used for identify BaseUsers of the app
 */
@Entity // This tells Hibernate to make a table out of this class
public class BaseUser implements User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idUser;
    private String username;
    private String email;
    private String parola;
    private String adresa;
    private int tip;

    @OneToMany
    private List<Game> games=new ArrayList<>();

    @OneToMany
    private List<Bill> bills=new ArrayList<>();

    /**
     *
     * @param username string
     * @param email string
     * @param parola string
     * @param adresa string
     * @param tip int
     */
    public BaseUser(String username, String email, String parola, String adresa, int tip) {
        this.username = username;
        this.email = email;
        this.parola = parola;
        this.adresa = adresa;
        this.tip = tip;
    }


    /**
     * Method Implementation
     * @return Integer
     */
    public Integer getIdUser() { return idUser; }

    /**
     * Method Implementation
     * @param idUser integer
     */

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    /**
     * Method Implementation
     * @return String
     */

    public String getUsername() {
        return username;
    }

    /**
     * Method Implementation
     * @param username string
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method Implementation
     * @return String
     */

    public String getEmail() {
        return email;
    }

    /**
     * Method Implementation
     * @param email string
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method Implementation
     * @return String
     */
    public String getParola() {
        return parola;
    }

    /**
     * Method Implementation
     * @param parola string
     */
    public void setParola(String parola) {
        this.parola = parola;
    }

    /**
     * Method Implementation
     * @return String
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Method Implementation
     * @param adresa string
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Method Implementation
     * @return int
     */
    public int isTip() {
        return tip;
    }

    /**
     * Method Implementation
     * @param tip int
     */
    public void setTip(int tip) {
        this.tip = tip;
    }

    /**
     * Method Implementation
     * @return int
     */
    public int getTip() {
        return tip;
    }

    /**
     * Method Implementation
     * @return List games
     */
    public List<Game> getGames() {
        return games;
    }

    /**
     * Method Implementation
     * @param games object
     */
    public void setGames(List<Game> games) {
        this.games = games;
    }

    /**
     * Method Implementation
     * @return List bills
     */
    public List<Bill> getBills() { return bills; }

    /**
     * Method Implementation
     * @param bills
     */
    public void setBills(List<Bill> bills) { this.bills = bills; }


    /**
     * default constructor
     */
    public BaseUser() {
    }

    /**
     * This method return our object under a string form for a better visualization
     * @return String
     */
    @Override
    public String toString() {
        return "idUser " + idUser +
                " username " + username  +
                " email " + email  +
                " parola " + parola  +
                " adresa " + adresa  +
                " tip " + tip +
                " games " + games.toString() +
                " bills " + bills;
    }

}
