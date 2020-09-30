package app.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
    @NamedQuery(name = "ArticleInteraction.findAll", query = "SELECT a FROM Comment a"),
    @NamedQuery(name = "ArticleInteraction.findByEmail", query = "SELECT a FROM Comment a WHERE a.account.email = :email")
})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date_posted")
    private LocalDate datePosted;

    @JoinColumn(name = "account_id", referencedColumnName = "email")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @JoinColumn(name = "article_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    public Comment(String comment, Account account, Article article) {
        this.comment = comment;
        this.account = account;
        this.article = article;
    }

    public Comment(Integer commentId, Account account, Article article) {
        this.commentId = commentId;
        this.account = account;
        this.article = article;
    }
}
