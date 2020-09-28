package app.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "emotion")
@Getter
@Setter
@NoArgsConstructor
@NamedQueries({
    @NamedQuery(name = "Emotion.isLiked", query = "SELECT e FROM Emotion e WHERE e.isLike = true "
            + "AND e.account.email = :email AND e.article.articleId = :articleId"),
    @NamedQuery(name = "Emotion.isDisliked", query = "SELECT e FROM Emotion e WHERE e.isDislike = true "
            + "AND e.account.email = :email AND e.article.articleId = :articleId"),
    @NamedQuery(name = "Emotion.countLike", query = "SELECT COUNT(e) FROM Emotion e WHERE e.isLike = true"
            + " AND e.article.articleId = :articleId"),
    @NamedQuery(name = "Emotion.countDislike", query = "SELECT COUNT(e) FROM Emotion e WHERE e.isDislike = true"
            + " AND e.article.articleId = :articleId"),
    @NamedQuery(name = "Emotion.findByEmailAndArticleId", query = "SELECT e FROM Emotion e"
            + " WHERE e.account.email = :email AND e.article.articleId = :articleId")
})
public class Emotion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emotion_id")
    private Integer emotionId;

    @Column(name = "is_like")
    private boolean isLike;

    @Column(name = "is_dislike")
    private boolean isDislike;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "account_id", referencedColumnName = "email")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "article_id")
    private Article article;

    public Emotion(boolean isLike, boolean isDislike, Account account, Article article) {
        this.isLike = isLike;
        this.isDislike = isDislike;
        this.account = account;
        this.article = article;
    }
}
