package data.dao;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import data.domain.*;

//This class implements Singleton and DAO patterns
public class ChallengeWithTimeDAO extends DataAccessObjectBase implements IDataAccessObject<ChallengeWithTime> {
    private static ChallengeWithTimeDAO instance;

    private ChallengeWithTimeDAO() { }

    public static ChallengeWithTimeDAO getInstance() {
        if (instance == null) {
            instance = new ChallengeWithTimeDAO();
        }

        return instance;
    }

    @Override
    public void save(ChallengeWithTime object) {
        super.saveObject(object);
    }

    @Override
    public void delete(ChallengeWithTime object) {
        super.deleteObject(object);
    }

    @Override
    public List<ChallengeWithTime> getAll() {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        List<ChallengeWithTime> challenges = new ArrayList<>();

        try {
            tx.begin();

            Extent<ChallengeWithTime> extent = pm.getExtent(ChallengeWithTime.class, true);

            for (ChallengeWithTime category : extent) {
                challenges.add(category);
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

        return challenges;
    }

    @Override
    public ChallengeWithTime find(String name) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        ChallengeWithTime result = null;

        try {
            tx.begin();

            Query<?> query = pm.newQuery("SELECT FROM " + ChallengeWithTime.class.getName() + " WHERE name == " + name);
            query.setUnique(true);
            result = (ChallengeWithTime) query.execute();

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


