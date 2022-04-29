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
     * Method Implementation
     * @return Integer
     */
    public Integer getIdFactura() {
        return idFactura;
    }

    /**
     * Method Implementation
     * @param idFactura integer
     */
    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    /**
     * Method Implementation
     * @return String
     */
    public String getNume() {
        return nume;
    }

    /**
     * Method Implementation
     * @param nume string
     */
    public void setNume(String nume) {
        this.nume = nume;
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
     * @return float
     */
    public float getSuma() {
        return suma;
    }

    /**
     * Method Implementation
     * @param suma float
     */
    public void setSuma(float suma) {
        this.suma = suma;
    }

    /**
     * This method return our object under a string form for a better visualization
     * @return String
     */
    @Override
    public String toString() {
        return "idFactura " + idFactura +
                ", nume " + nume +
                ", adresa " + adresa +
                ", suma " + suma;
    }
}
