package app.dao;

import app.dto.Comment;
import app.util.DBUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class ArticleInteractionDAO implements Serializable {
    
    public Collection<Comment> getComments(int articleId) {
        EntityManager manager = DBUtil.getEntityManager();
        Collection<Comment> comments = Collections.EMPTY_LIST;
        
        try {
            manager.getTransaction().begin();
            comments = manager.createQuery("SELECT new app.dto.Comment(ai.interactionId, ai.account.name, ai.account.email, ai.comment, ai.isLike, ai.isDislike)"
                    + " FROM ArticleInteraction ai WHERE ai.article.articleId = :articleId AND ai.comment != null")
                    .setParameter("articleId", articleId)
                    .getResultList();
            manager.getTransaction().commit();
        } catch (NoResultException error) {
            
            return Collections.EMPTY_LIST;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Fail to load all comments in database", error);
        }  finally {
            if (manager != null ) {
                manager.close();
            }
        }
        
        return comments;
    }

    public boolean isLiked(int articleId, String email) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();

            Long isLiked = manager.createQuery("SELECT CASE WHEN a.isLike = true THEN true ELSE false END"
                    + " FROM ArticleInteraction a WHERE a.article.articleId = :articleId AND a.account.email = :email", Long.class)
                    .setParameter("articleId", articleId)
                    .setParameter("email", email)
                    .getSingleResult();
            
            manager.getTransaction().commit();
            
            return isLiked > 0;
        } catch (NoResultException error) {
            
            return false;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Fail to find account in database", error);
            
            return false;
        } finally {
            if (manager != null ) {
                manager.close();
            }
        }
    }
    
    public boolean isDisliked(int articleId, String email) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();

            Long isLiked = manager.createQuery("SELECT CASE WHEN a.isDislike = true THEN true ELSE false END"
                    + " FROM ArticleInteraction a WHERE a.article.articleId = :articleId AND a.account.email = :email", Long.class)
                    .setParameter("articleId", articleId)
                    .setParameter("email", email)
                    .getSingleResult();
            
            manager.getTransaction().commit();
            
            return isLiked > 0;
        } catch (NoResultException error) {
            
            return false;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Fail to find account in database", error);
            
            return false;
        } finally {
            if (manager != null ) {
                manager.close();
            }
        }
    }
}
