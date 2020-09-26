package app.entity;

import app.entity.Account;
import app.entity.ArticleStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-09-25T18:05:05")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile SingularAttribute<Article, Date> date;
    public static volatile SingularAttribute<Article, Account> owner;
    public static volatile SingularAttribute<Article, String> image;
    public static volatile SingularAttribute<Article, Integer> articleId;
    public static volatile SingularAttribute<Article, String> description;
    public static volatile SingularAttribute<Article, String> title;
    public static volatile SingularAttribute<Article, ArticleStatus> status;

}