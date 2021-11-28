package services;

import data.domain.*;
import data.dao.*;

public class RegisterAppService {
<<<<<<< Updated upstream
=======

    //Instance for the Singleton Pattern
    private static RegisterAppService instance;

    private RegisterAppService() { }

    public static RegisterAppService getInstance() {
        if (instance == null) {
            instance = new RegisterAppService();
        }

        return instance;
    }

    public PasswordProfile register(String googleOrFacebook, String email, String password) {
        //TODO: Get p1 using DAO and check
        PasswordProfile p1 = PasswordProfileDAO.getInstance().find(email);

        if (p1 == null) {
            PasswordProfile p2 = new PasswordProfile();
            p2.setEmail(email);
            p2.setPassword(password);
            return p2;
        }
        return null;
    }
>>>>>>> Stashed changes
}
