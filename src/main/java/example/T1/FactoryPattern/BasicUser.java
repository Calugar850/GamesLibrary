package example.T1.FactoryPattern;

public abstract class BasicUser {
    String name = null;
    String prenume = null;
    public DataSource data;

    public BasicUser(String name, String prenume) {
        this.name = name;
        this.prenume = prenume;
        data=new Data();
    }

    public abstract int zile();
}
