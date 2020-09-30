package app.dao;

import app.entity.Emotion;
import app.util.DBUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class EmotionDAO implements Serializable {

    public Emotion findByEmailAndArticleId(String email, int articleId) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            Emotion emotion = manager.createNamedQuery("Emotion.findByEmailAndArticleId", Emotion.class)
                    .setParameter("email", email)
                    .setParameter("articleId", articleId)
                    .getSingleResult();
            manager.getTransaction().commit();

            return emotion;
        } catch (NoResultException error) {

            return null;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EmotionDAO.findByEmailAndArticleId()", error);

            return null;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public void saveEmotion(Emotion emotion) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(emotion);
            manager.getTransaction().commit();
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EmotionDAO.saveEmotion()", error);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public void updateEmotion(Emotion emotion) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            manager.merge(emotion);
            manager.getTransaction().commit();
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EmotionDAO.updateEmotion()", error);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public boolean isLiked(String email, int articleId) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            Emotion emotion = manager.createNamedQuery("Emotion.isLiked", Emotion.class)
                    .setParameter("email", email)
                    .setParameter("articleId", articleId)
                    .getSingleResult();
            manager.getTransaction().commit();

            return emotion != null;
        } catch (NoResultException error) {

            return false;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EmotionDAO.isLiked()", error);

            return false;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public boolean isDisliked(String email, int articleId) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            Emotion emotion = manager.createNamedQuery("Emotion.isDisliked", Emotion.class)
                    .setParameter("email", email)
                    .setParameter("articleId", articleId)
                    .getSingleResult();
            manager.getTransaction().commit();

            return emotion != null;
        } catch (NoResultException error) {

            return false;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EmotionDAO.isDisliked()", error);

            return false;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public int countLike(int articleId) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            long likeNumber = manager.createNamedQuery("Emotion.countLike", Long.class)
                    .setParameter("articleId", articleId)
                    .getSingleResult();
            manager.getTransaction().commit();

            return (int) likeNumber;
        } catch (NoResultException error) {

            return 0;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EmotionDAO.countLike()", error);

            return 0;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public int countDislike(int articleId) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            long likeNumber = manager.createNamedQuery("Emotion.countDislike", Long.class)
                    .setParameter("articleId", articleId)
                    .getSingleResult();
            manager.getTransaction().commit();

            return (int) likeNumber;
        } catch (NoResultException error) {

            return 0;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EmotionDAO.countDislike()", error);

            return 0;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
}
