package example.T1.FactoryPattern;

public class Colaborator extends BasicUser {
    public Colaborator(String name, String prenume) {
        super(name, prenume);
    }

    @Override
    public int zile() {
        return super.data.days() * 8;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        return obj instanceof Colaborator;
    }
}
