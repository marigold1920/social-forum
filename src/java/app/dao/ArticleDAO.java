package app.dao;

import app.dto.ArticleDTO;
import app.dto.ArticleDetailsDTO;
import app.util.Constant;
import app.util.DBUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ArticleDAO implements Serializable {

    public Collection<ArticleDTO> findAllAndPaging(int pageNumber) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("SELECT new app.dto.ArticleDTO(a.articleId, a.title, a.description, a.image, a.publishedDate)"
                    + " FROM Article a ORDER BY a.publishedDate DESC");
            query.setFirstResult((pageNumber - 1) * Constant.PAGE_SIZE);
            query.setMaxResults(Constant.PAGE_SIZE);
            Collection<ArticleDTO> articles = (Collection<ArticleDTO>) query.getResultList();
            manager.getTransaction().commit();

            return articles;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "ArticleDAO.findAllAndPaging()", error);

            return Collections.EMPTY_LIST;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
    
    public Collection<ArticleDTO> searchByContentAndPaging(String keyword, int pageNumber) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("SELECT new app.dto.ArticleDTO(a.articleId, a.title, a.description, a.image, a.publishedDate)"
                    + " FROM Article a WHERE a.content LIKE CONCAT('%',:keyword,'%') ORDER BY a.publishedDate DESC");
            query.setFirstResult((pageNumber - 1) * Constant.PAGE_SIZE);
            query.setMaxResults(Constant.PAGE_SIZE);
            query.setParameter("keyword", keyword);
            Collection<ArticleDTO> articles = (Collection<ArticleDTO>) query.getResultList();
            manager.getTransaction().commit();

            return articles;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "ArticleDAO.searchByContentAndPaging()", error);

            return Collections.EMPTY_LIST;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public ArticleDetailsDTO getArticleDetails(int articleId, String email) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            ArticleDetailsDTO article = manager.createQuery("SELECT new app.dto.ArticleDetailsDTO(a.articleId, a.title, a.content, a.publishedDate) "
                    + "FROM Article a WHERE a.articleId = :articleId", ArticleDetailsDTO.class)
                    .setParameter("articleId", articleId)
                    .getSingleResult();
            manager.getTransaction().commit();

            return article;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "ArticleDAO.getArticleDetails()", error);

            return null;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
}
