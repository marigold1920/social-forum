package app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "article_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "status_id")
    private String statusId;
    
    @Column(name = "name")
    private String name;
}
