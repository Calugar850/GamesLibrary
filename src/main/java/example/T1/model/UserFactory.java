package example.T1.model;

public class UserFactory {
    private Integer idUser;
    private String username;
    private String email;
    private String parola;
    private String adresa;
    private int tip;


    public UserFactory(String username, String email, String parola, String adresa, int tip) {
        this.username = username;
        this.email = email;
        this.parola = parola;
        this.adresa = adresa;
        this.tip = tip;
    }

    /**
     * This method create a type of User based of value of EnumUsers
     * @param  e (EnumUsers)
     * @return User
     */
    public User createUser(EnumUsers e) {
        User user;
        if (e == EnumUsers.BaseUser) {
            user = new BaseUser(username,email,parola,adresa,tip);
            return user;
        } else if (e == EnumUsers.PremiumUser) {
            user = new PremiumUser(username,email,parola,adresa,tip);
            return user;
        } else if (e == EnumUsers.AdminUser) {
            user = new AdminUser(username,email,parola,adresa,tip);
            return user;
        }
        return null;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
