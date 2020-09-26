package app.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static EntityManagerFactory manager;
    
    public static EntityManager getEntityManager() {
        if (manager == null) {
            manager = Persistence.createEntityManagerFactory("ForumPersistence");
        }
        
        return manager.createEntityManager();
    }
}
