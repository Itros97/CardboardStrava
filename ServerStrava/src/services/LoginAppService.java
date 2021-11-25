package services;

import data.domain.Profile;

public class LoginAppService {

    public Profile login(String email, String password) {
        //TODO: Get p1 using DAO and check 		
        Profile p1 = new Profile();
        p1.setEmail("thomas.e2001@gmail.com");
        p1.setNickname("Thomas");
        //Generate the hash of the password
        String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
        p1.setPassword(sha1);

        if (p1.getEmail().equals(email) && p1.isPassword(password)) {
            return p1;
        } else {
            return null;
        }
    }
}
