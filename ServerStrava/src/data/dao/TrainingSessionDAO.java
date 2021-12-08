package data.dao;

import data.domain.TrainingSession;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import java.util.ArrayList;
import java.util.List;

//This class implements Singleton and DAO patterns
public class TrainingSessionDAO extends DataAccessObjectBase implements IDataAccessObject<TrainingSession> {
    private static TrainingSessionDAO instance;

    private TrainingSessionDAO() { }

    public static TrainingSessionDAO getInstance() {
        if (instance == null) {
            instance = new TrainingSessionDAO();
        }

        return instance;
    }

    @Override
    public void save(TrainingSession object) {
        super.saveObject(object);
    }

    @Override
    public void delete(TrainingSession object) {
        super.deleteObject(object);
    }

    @Override
    public List<TrainingSession> getAll() {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        List<TrainingSession> trainingSessions = new ArrayList<>();

        try {
            tx.begin();

            Extent<TrainingSession> extent = pm.getExtent(TrainingSession.class, true);

            for (TrainingSession category : extent) {
                trainingSessions.add(category);
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

        return trainingSessions;
    }

    @Override
    public TrainingSession find(String title) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        TrainingSession result = null;

        try {
            tx.begin();

            TrainingSession ts = new TrainingSession();
            ts.setTitle(title);

            Query<?> query = pm.newQuery("SELECT FROM " + ts.getTitle() + " WHERE title == " + title);
            query.setUnique(true);
            result = (TrainingSession) query.execute();

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