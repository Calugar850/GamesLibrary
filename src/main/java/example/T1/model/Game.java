package example.T1.model;

import javax.persistence.*;

/**
 * This class is game model for Database
 */
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idGame;
    private String nume;
    private int anAparitie;
    private String publisher;
    private float pret;
    private String gen;
    private String descriere;

    /**
     * default constructor
     */
    public Game(){

    }

    /**
     *
     * @param nume string
     * @param anAparitie int
     * @param publisher string
     * @param pret flaot
     * @param gen string
     * @param descriere string
     */
    public Game(String nume, int anAparitie, String publisher, float pret, String gen, String descriere) {
        this.nume = nume;
        this.anAparitie = anAparitie;
        this.publisher = publisher;
        this.pret = pret;
        this.gen = gen;
        this.descriere = descriere;
    }

    /**
     *
     * @return Integer
     */
    public Integer getIdGame() {
        return idGame;
    }

    /**
     *
     * @param idGame integer
     */
    public void setIdGame(Integer idGame) {
        this.idGame = idGame;
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
     * @return int
     */
    public int getAnAparitie() {
        return anAparitie;
    }

    /**
     *
     * @param anAparitie int
     */
    public void setAnAparitie(int anAparitie) {
        this.anAparitie = anAparitie;
    }

    /**
     *
     * @return String
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     *
     * @param publisher string
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     *
     * @return float
     */
    public float getPret() {
        return pret;
    }

    /**
     *
     * @param pret float
     */
    public void setPret(float pret) {
        this.pret = pret;
    }

    /**
     *
     * @return String
     */
    public String getGen() {
        return gen;
    }

    /**
     *
     * @param gen string
     */
    public void setGen(String gen) {
        this.gen = gen;
    }

    /**
     *
     * @return String
     */
    public String getDescriere() {
        return descriere;
    }

    /**
     *
     * @param descriere string
     */
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
