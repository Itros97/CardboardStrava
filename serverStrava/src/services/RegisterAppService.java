package services;

import data.domain.*;
import gateway.*;

public class RegisterAppService {
    public boolean register(String googleOrFacebook, String email, String password) {
        //TODO: Get p1 using DAO and check
        PasswordProfile p1 = new PasswordProfile();
        p1.setEmail("thomas.e2001@gmail.com");
        p1.setNickname("Thomas");
        //Generate the hash of the password
        String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
        p1.setPassword(sha1);

        //Se completa el registro si no hay ningun usuario con el mismo mail
        return !p1.getEmail().equals(email);
    }
}
