package example.T1.FactoryPattern;

public class Angajat extends BasicUser {
    public Angajat(String name, String prenume) {
        super(name, prenume);
    }

    @Override
    public int zile() {
        return super.data.days() * 12;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    public boolean equals(Object obj) {
        return obj instanceof Angajat;
    }
}
