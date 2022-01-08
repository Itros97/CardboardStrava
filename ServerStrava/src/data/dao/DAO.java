package data.dao;


import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class DAO {

    private static DAO instance = null;

    PersistenceManagerFactory pmf;

    public DAO() {
        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    }

    public static DAO getInstance() {
        if (instance == null) {
            instance = new DAO();

        }

        return instance;
    }


}
