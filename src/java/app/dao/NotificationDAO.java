package app.dao;

import app.dto.NotificationDTO;
import app.entity.Notification;
import app.util.DBUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
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

    public Collection<NotificationDTO> findAllByEmail(String email) {
        EntityManager manager = DBUtil.getEntityManager();
        String query = "SELECT new app.dto.NotificationDTO(n.notificationId, n.content, n.createdDate, n.owner.name, n.article.articleId)"
                + " FROM Notification n WHERE n.isRead = false AND n.article.owner.email = :email AND n.article.status.name = 'Active'"
                + " ORDER BY n.createdDate DESC, n.notificationId DESC";

        try {
            manager.getTransaction().begin();
            Collection<NotificationDTO> notifications = manager.createQuery(query)
                    .setParameter("email", email)
                    .getResultList();
            manager.getTransaction().commit();

            return notifications;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "NotificationDAO.findAllByEmail()", error);

            return Collections.EMPTY_LIST;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
}
