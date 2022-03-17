package example.T1.model;

import javax.persistence.*;
import example.T1.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is bill model for Database
 */
@Entity // This tells Hibernate to make a table out of this class
public class Bill {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idFactura;
    private String nume;
    private String adresa;
    private float suma;

    @OneToMany
    private List<Game> games=new ArrayList<>();

    /*@OneToOne
    private User user;
    */

    /**
     * default constructor
     */
    public Bill(){ }

    /**
     *
     * @param nume string
     * @param adresa string
     * @param suma float
     */
    public Bill(String nume, String adresa, float suma) {
        this.nume = nume;
        this.adresa = adresa;
        this.suma = suma;
    }

    /**
     *
     * @return Integer
     */
    public Integer getIdFactura() {
        return idFactura;
    }

    /**
     *
     * @param idFactura integer
     */
    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    /**
     *
     * @return String
     */
    public String getNume() {
        return nume;
    }

    /**
     *
     * @param nume string
     */
    public void setNume(String nume) {
        this.nume = nume;
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
     * @return float
     */
    public float getSuma() {
        return suma;
    }

    /**
     *
     * @param suma float
     */
    public void setSuma(float suma) {
        this.suma = suma;
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
}
