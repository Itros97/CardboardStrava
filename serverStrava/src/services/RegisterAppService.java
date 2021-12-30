package services;

import data.dao.PasswordProfileDAO;
import data.domain.PasswordProfile;

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

    public void register(PasswordProfile pp) {
        /*if (pp.getRegisterType().equals("Google")) {
            if (pp.getEmail() != null && pp.getPassword() != null) {
                GoogleGateway.getInstance().register(pp);
            }
        } else if (pp.getRegisterType().equals("Facebook")) {
            if (pp.getEmail() != null && pp.getPassword() != null) {
                FacebookGateway.getInstance().register(pp);
            }
        } else {
            if (pp.getEmail() != null && pp.getPassword() != null) {*/
                //Save the PasswordProfile in the DB using DAO Pattern
                PasswordProfileDAO.getInstance().save(pp);
            /*}
        }*/
    }
}
