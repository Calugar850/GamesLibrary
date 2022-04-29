package example.T1.FactoryPattern;

public class FactoryUser {

    public BasicUser createBasicUser(Enums enums){
        BasicUser basicUser1;
        if(enums == Enums.Angajat){
            basicUser1 = new Angajat(null,null);
            return basicUser1;
        }
        else if(enums == Enums.Colaborator){
            basicUser1 = new Colaborator(null,null);
            return basicUser1;
        }
        else if(enums == Enums.Vizitator){
            basicUser1 = new Vizitator(null,null);
            return basicUser1;
        }
        return null;
    }

}
