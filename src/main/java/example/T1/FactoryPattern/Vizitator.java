package example.T1.FactoryPattern;

public class Vizitator extends BasicUser {
    public Vizitator(String name, String prenume) {
        super(name, prenume);
    }

    @Override
    public int zile() {
        return super.data.days() * 2;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        return obj instanceof Vizitator;
    }
}
