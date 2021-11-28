package services;

import data.domain.*;
import gateway.*;

public class LoginAppService {

    public PasswordProfile login(String email, String password) {
        //TODO: Get p1 using DAO and check 		
        PasswordProfile p1 = new PasswordProfile();
        p1.setEmail("thomas.e2001@gmail.com");
        p1.setNickname("Thomas");
        //Generate the hash of the password
        String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
        p1.setPassword(sha1);

        if (p1.getEmail().equals(email) && p1.getPassword().equals(password)) {
            return p1;
        } else {
            return null;
        }
    }
}
