package data;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class PasswordProfile extends Profile {
    private String password;

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
