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
    
    private String title;
    private String content;
    private LocalDate publishedDate;
    private Integer likeNumber;
    private Integer dislikeNumber;

    public ArticleDetailsDTO(String title, String content, LocalDate publishedDate) {
        this.title = title;
        this.content = content;
        this.publishedDate = publishedDate;
    }
}
