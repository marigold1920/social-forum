package app.dao;

import app.entity.Account;
import app.util.DBUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class AccountDAO {

    public void saveAccount(Account account) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(account);
            manager.getTransaction().commit();
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "AccountDAO.saveAccount()", error);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public Account findAccountByEmailAndPassword(String email, String password) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            Account account = manager.createNamedQuery("Account.findByEmailAndPassword", Account.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
            manager.getTransaction().commit();

            return account;
        } catch (NoResultException error) {
            return null;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "AccountDAO.findAccountByEmailAndPassword()", error);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }

        return null;
    }

    public boolean isExistedAccount(String email) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            Account account = manager.createNamedQuery("Account.findByEmail", Account.class)
                    .setParameter("email", email)
                    .getSingleResult();
            manager.getTransaction().commit();

            return account != null;
        } catch (NoResultException error) {
            return false;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "AccountDAO.isExistedAccount()", error);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }

        return false;
    }
}
