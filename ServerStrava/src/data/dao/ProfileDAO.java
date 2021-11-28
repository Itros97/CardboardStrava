package data.dao;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import data.domain.*;

//This class implements Singleton and DAO patterns
public class ProfileDAO extends DataAccessObjectBase implements IDataAccessObject<Profile> {
    private static ProfileDAO instance;

    private ProfileDAO() { }

    public static ProfileDAO getInstance() {
        if (instance == null) {
            instance = new ProfileDAO();
        }

        return instance;
    }

    @Override
    public void save(Profile object) {
        super.saveObject(object);
    }

    @Override
    public void delete(Profile object) {
        super.deleteObject(object);
    }

    @Override
    public List<Profile> getAll() {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        List<Profile> profiles = new ArrayList<>();

        try {
            tx.begin();

            Extent<Profile> extent = pm.getExtent(Profile.class, true);

            for (Profile category : extent) {
                profiles.add(category);
            }

            tx.commit();
        } catch (Exception ex) {
            System.out.println("  $ Error retrieving all the Articles: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            pm.close();
        }

        return profiles;
    }

    @Override
    public Profile find(String email) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        Profile result = null;

        try {
            tx.begin();

            Query<?> query = pm.newQuery("SELECT FROM " + Profile.class.getEmail() + " WHERE email == " + email);
            query.setUnique(true);
            result = (Profile) query.execute();

            tx.commit();
        } catch (Exception ex) {
            System.out.println("  $ Error querying an Article: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            pm.close();
        }

        return result;
    }
}
