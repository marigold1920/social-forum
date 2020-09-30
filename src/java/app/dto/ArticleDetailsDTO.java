package app.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDetailsDTO implements Serializable {

    private Integer articleId;
    private String title;
    private String content;
    private LocalDate publishedDate;
    private Integer likeNumber;
    private Integer dislikeNumber;
    private String owner;

    public ArticleDetailsDTO(Integer articleId, String title, String content, LocalDate publishedDate, String owner) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.publishedDate = publishedDate;
        this.owner = owner;
    }
}
