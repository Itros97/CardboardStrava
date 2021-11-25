package services;



public class LoginAppService {

    public Profile login(String email, String password) {
        Profile user = new Profile();
        user.setEmail("root@admin.com");
        user.setNickname("root");


        String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
        user.setPassword(sha1);

        if (user.getEmail().equals(email) && user.isPassword(password)) {
            return user;
        } else {
            return null;
        }
    }
}
