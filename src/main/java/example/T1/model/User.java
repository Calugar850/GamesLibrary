package example.T1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import example.T1.FactoryPattern.Angajat;
import example.T1.FactoryPattern.Colaborator;
import example.T1.FactoryPattern.Enums;
import example.T1.FactoryPattern.Vizitator;
import example.T1.model.Game;

/**
 * This interface is used for Factory Pattern Implementation
 */

public interface User {

    /**
     * Method Declaration
     * @return Integer
     */
    public Integer getIdUser();

    /**
     * Method Declaration
     * @param idUser integer
     */
    public void setIdUser(Integer idUser);

    /**
     * Method Declaration
     * @return String
     */
    public String getUsername();

    /**
     * Method Declaration
     * @param username string
     */
    public void setUsername(String username);

    /**
     * Method Declaration
     * @return String
     */
    public String getEmail();

    /**
     * Method Declaration
     * @param email string
     */
    public void setEmail(String email);

    /**
     * Method Declaration
     * @return String
     */
    public String getParola();

    /**
     * Method Declaration
     * @param parola string
     */
    public void setParola(String parola);

    /**
     * Method Declaration
     * @return String
     */
    public String getAdresa();

    /**
     * Method Declaration
     * @param adresa string
     */
    public void setAdresa(String adresa);

    /**
     * Method Declaration
     * @return int
     */
    public int isTip();

    /**
     * Method Declaration
     * @param tip int
     */
    public void setTip(int tip);

    /**
     * Method Declaration
     * @return int
     */
    public int getTip();

    /**
     * Method Declaration
     * @return List games
     */
    public List<Game> getGames();

    /**
     * Method Declaration
     * @param games object
     */
    public void setGames(List<Game> games);

    /**
     * Method Declaration
     * @return List bills
     */
    public List<Bill> getBills();

    /**
     * Method Declaration
     * @param bills
     */
    public void setBills(List<Bill> bills);

    /**
     * Method Declaration
     * @return string
     */
    @Override
    public String toString();

}

