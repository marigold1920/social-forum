package app.dao;

import app.dto.CommentDTO;
import app.entity.Comment;
import app.util.DBUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class CommentDAO implements Serializable {

    public Collection<CommentDTO> getComments(int articleId) {
        EntityManager manager = DBUtil.getEntityManager();
        Collection<CommentDTO> comments = Collections.EMPTY_LIST;

        try {
            manager.getTransaction().begin();
            comments = manager.createQuery("SELECT new app.dto.CommentDTO(c.commentId, c.account.name, c.account.email, c.comment, c.datePosted)"
                    + " FROM Comment c WHERE c.article.articleId = :articleId ORDER BY c.datePosted DESC, c.commentId DESC")
                    .setParameter("articleId", articleId)
                    .getResultList();
            manager.getTransaction().commit();
        } catch (NoResultException error) {

            return Collections.EMPTY_LIST;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Fail to load all comments in database", error);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }

        return comments;
    }
    
    public void saveComment(Comment comment) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(comment);
            manager.getTransaction().commit();
         } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Fail to save comment to database", error);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
    
    public void removeComment(Comment comment) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            manager.remove(manager.merge(comment));
            manager.getTransaction().commit();
         } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Fail to remove comment to database", error);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
}
