package app.entity;

import app.entity.Article;
import app.entity.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-09-25T18:05:05")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, Role> role;
    public static volatile SingularAttribute<Account, String> name;
    public static volatile CollectionAttribute<Account, Article> articles;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, String> status;

}