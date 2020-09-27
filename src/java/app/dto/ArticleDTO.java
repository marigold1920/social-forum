package app.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ArticleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer articleId;
    private String title;
    private String description;
    private String image;
    private LocalDate publishedDate;
}
