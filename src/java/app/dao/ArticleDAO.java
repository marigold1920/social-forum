package app.dao;

import app.dto.ArticleDTO;
import app.entity.Article;
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

    public Collection<ArticleDTO> findAll(int pageNumber) {
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
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Fail to load article from database", error);

            return Collections.EMPTY_LIST;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
    
    public Article getArticleDetails(int articleId) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            Article article = manager.createQuery("SELECT a FROM Article a WHERE a.articleId = :articleId", Article.class)
                    .setParameter("articleId", articleId)
                    .getSingleResult();
            manager.getTransaction().commit();
 
            return article;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Fail to load article from database", error);

            return null;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
}