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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "article_interaction")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "ArticleInteraction.findAll", query = "SELECT a FROM ArticleInteraction a")})
public class ArticleInteraction implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interaction_id")
    private Integer interactionId;
    
    @Column(name = "is_like")
    private boolean isLike;
    
    @Column(name = "is_dislike")
    private boolean isDislike;
    
    @Column(name = "interaction_date")
    private LocalDate interactionDate;
    
    @JoinColumn(name = "account_id", referencedColumnName = "email")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account accountId; 
}
