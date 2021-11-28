package services;

import data.domain.*;
import data.dao.*;

public class LoginAppService {

<<<<<<< Updated upstream
    public Profile login(String email, String password) {
        //TODO: Get p1 using DAO and check 		
        Profile p1 = new Profile();
        p1.setEmail("thomas.e2001@gmail.com");
        p1.setNickname("Thomas");
        //Generate the hash of the password
        String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
        p1.setPassword(sha1);

        if (p1.getEmail().equals(email) && p1.isPassword(password)) {
=======
    //Instance for the Singleton Pattern
    private static LoginAppService instance;

    private LoginAppService() { }

    public static LoginAppService getInstance() {
        if (instance == null) {
            instance = new LoginAppService();
        }

        return instance;
    }

    public PasswordProfile login(String email, String password) {
        //TODO: Get p1 using DAO and check 		
        PasswordProfile p1 = PasswordProfileDAO.getInstance().find(email);

        if (p1 != null && p1.getEmail().equals(email) && p1.getPassword().equals(password)) {
>>>>>>> Stashed changes
            return p1;
        }
        return null;
    }
}
