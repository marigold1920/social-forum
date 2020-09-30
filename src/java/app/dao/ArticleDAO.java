package app.dao;

import app.dto.ArticleDTO;
import app.dto.ArticleDetailsDTO;
import app.entity.Article;
import app.util.Constant;
import app.util.DBUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ArticleDAO implements Serializable {

    public boolean saveArticle(Article article) {
        EntityManager manager = DBUtil.getEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(article);
            manager.getTransaction().commit();

            return true;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "ArticleDAO.saveArticle()", error);

            return false;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public Collection<ArticleDTO> findAllAndPaging(String keyword, int pageNumber) {
        EntityManager manager = DBUtil.getEntityManager();
        String queryStr = "SELECT new app.dto.ArticleDTO(a.articleId, a.title, a.description, a.image, a.publishedDate)"
                + " FROM Article a WHERE a.status.isDefault = true AND a.content LIKE CONCAT('%', :keyword,'%')"
                + " ORDER BY a.publishedDate DESC, a.articleId DESC";

        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery(queryStr);
            query.setFirstResult((pageNumber - 1) * Constant.PAGE_SIZE);
            query.setMaxResults(Constant.PAGE_SIZE);
            query.setParameter("keyword", keyword);
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

    public ArticleDetailsDTO getArticleDetails(int articleId, String email) {
        EntityManager manager = DBUtil.getEntityManager();
        String query = "SELECT new app.dto.ArticleDetailsDTO(a.articleId, a.title, a.content, a.publishedDate, a.owner.email)"
                + " FROM Article a WHERE a.articleId = :articleId";

        try {
            manager.getTransaction().begin();
            ArticleDetailsDTO article = manager.createQuery(query, ArticleDetailsDTO.class)
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

    public int getTotalPage(String keyword) {
        EntityManager manager = DBUtil.getEntityManager();
        String query = "SELECT COUNT(a.articleId) FROM Article a"
                + " WHERE a.status.isDefault = true AND a.content LIKE CONCAT('%',:keyword,'%')";

        try {
            manager.getTransaction().begin();
            long totalPage = manager.createQuery(query, Long.class)
                    .setParameter("keyword", keyword)
                    .getSingleResult();
            manager.getTransaction().commit();

            return (int) Math.ceil(totalPage * 1.0 / Constant.PAGE_SIZE);
        } catch (NoResultException error) {

            return 0;
        } catch (Exception error) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "ArticleDAO.getTotalPage()", error);

            return 0;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
}
