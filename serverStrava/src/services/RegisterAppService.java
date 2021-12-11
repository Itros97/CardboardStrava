package services;

import data.dao.PasswordProfileDAO;
import data.domain.PasswordProfile;
import gateway.GoogleGateway;

public class RegisterAppService {
    //Instance for Singleton Pattern
    private static RegisterAppService instance;

    public RegisterAppService() { }

    public static RegisterAppService getInstance() {
        if (instance == null) {
            instance = new RegisterAppService();
        }

        return instance;
    }

    public void register(String googleOrFacebook, PasswordProfile pp) {
        if (googleOrFacebook.equals("google")) {
            if (pp.getEmail() != null && pp.getPassword() != null) {
                GoogleGateway.getInstance().register(pp);
            }
        } else if (googleOrFacebook.equals("facebook")) {
            if (pp.getEmail() != null && pp.getPassword() != null) {
                //FacebookGateway.getInstance().register(pp);
            }
        } else {
            if (pp.getEmail() != null && pp.getPassword() != null) {
                //Save the PasswordProfile in the DB using DAO Pattern
                PasswordProfileDAO.getInstance().save(pp);
            }
        }
    }
}
