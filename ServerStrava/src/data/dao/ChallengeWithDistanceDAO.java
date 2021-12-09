package data.dao;

import data.domain.ChallengeWithDistance;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import java.util.ArrayList;
import java.util.List;

//This class implements Singleton and DAO patterns
public class ChallengeWithDistanceDAO extends DataAccessObjectBase implements IDataAccessObject<ChallengeWithDistance> {
    private static ChallengeWithDistanceDAO instance;

    private ChallengeWithDistanceDAO() { }

    public static ChallengeWithDistanceDAO getInstance() {
        if (instance == null) {
            instance = new ChallengeWithDistanceDAO();
        }

        return instance;
    }

    @Override
    public void save(ChallengeWithDistance object) {
        super.saveObject(object);
    }

    @Override
    public void delete(ChallengeWithDistance object) {
        super.deleteObject(object);
    }

    @Override
    public List<ChallengeWithDistance> getAll() {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        List<ChallengeWithDistance> challenges = new ArrayList<>();

        try {
            tx.begin();

            Extent<ChallengeWithDistance> extent = pm.getExtent(ChallengeWithDistance.class, true);

            for (ChallengeWithDistance category : extent) {
                challenges.add(category);
            }

            tx.commit();
        } catch (Exception ex) {
            System.out.println("  $ Error retrieving all the Challenges: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            pm.close();
        }

        return challenges;
    }

    @Override
    public ChallengeWithDistance find(String name) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        ChallengeWithDistance result = null;

        try {
            tx.begin();

            Query<?> query = pm.newQuery("SELECT FROM " + ChallengeWithDistance.class.getName() + " WHERE name == " + name);
            query.setUnique(true);
            result = (ChallengeWithDistance) query.execute();

            tx.commit();
        } catch (Exception ex) {
            System.out.println("  $ Error querying an Challenge: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            pm.close();
        }

        return result;
    }
}

