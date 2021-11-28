package data.dao;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import data.domain.*;

//This class implements Singleton and DAO patterns
public class PasswordProfileDAO extends DataAccessObjectBase implements IDataAccessObject<PasswordProfile> {
    private static PasswordProfileDAO instance;

    private PasswordProfileDAO() { }

    public static PasswordProfileDAO getInstance() {
        if (instance == null) {
            instance = new PasswordProfileDAO();
        }

        return instance;
    }

    @Override
    public void save(PasswordProfile object) {
        super.saveObject(object);
    }

    @Override
    public void delete(PasswordProfile object) {
        super.deleteObject(object);
    }

    @Override
    public List<PasswordProfile> getAll() {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        List<PasswordProfile> profiles = new ArrayList<>();

        try {
            tx.begin();

            Extent<PasswordProfile> extent = pm.getExtent(PasswordProfile.class, true);

            for (PasswordProfile category : extent) {
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
    public PasswordProfile find(String email) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        PasswordProfile result = null;

        try {
            tx.begin();

            Query<?> query = pm.newQuery("SELECT FROM " + PasswordProfile.class.getEmail() + " WHERE email == " + email);
            query.setUnique(true);
            result = (PasswordProfile) query.execute();

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
