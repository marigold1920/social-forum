package app.dao;

import app.entity.Notification;
import app.util.DBUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

public class NotificationDAO implements Serializable {
    
    public void saveNotification(Notification notification) {
        EntityManager manager = DBUtil.getEntityManager();
        
        try {
            manager.getTransaction().begin();
            manager.persist(notification);
            manager.getTransaction().commit();
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "NotificationDAO.saveNotification()", error);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
}
