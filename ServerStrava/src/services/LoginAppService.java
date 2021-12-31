package services;

import data.dao.PasswordProfileDAO;
import data.domain.PasswordProfile;
import gateway.FacebookGateway;
import gateway.GoogleGateway;

import java.util.ArrayList;
import java.util.List;

public class LoginAppService {
    //Instance for Singleton Pattern
    private static LoginAppService instance;

    public LoginAppService() { }

    public static LoginAppService getInstance() {
        if (instance == null) {
            instance = new LoginAppService();
        }

        return instance;
    }

    public boolean login(String googleOrFacebook, String email, String password) {
        if (googleOrFacebook.equals("google")) {
            if (email != null) {
                return GoogleGateway.getInstance().login(email, password);
            }
        } else if (googleOrFacebook.equals("facebook")) {
            if (email != null) {
                return FacebookGateway.getInstance().login(email, password);
            }
        } else {
            List<PasswordProfile> profiles = new ArrayList<PasswordProfile>();
            profiles = PasswordProfileDAO.getInstance().getAll();
                for (PasswordProfile pro : profiles) {
                    if (pro.getEmail().equals(email) && pro.getPassword().equals(password)) {
                        //El token que tiene que devolverse
                        return true;
                    }
                }
        }
        return false;
    }
}
