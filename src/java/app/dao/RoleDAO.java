package app.dao;

import app.entity.Role;
import app.util.DBUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

public class RoleDAO implements Serializable {

    public Role getDefaultRole() {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            Role role = manager.createNamedQuery("Role.findDefaultRole", Role.class)
                    .setParameter("isDefault", 1)
                    .getSingleResult();
            manager.getTransaction().commit();

            return role;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Fail to load role from database", error);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }

        return null;
    }
}
