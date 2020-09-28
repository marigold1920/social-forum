package app.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentDTO implements Serializable {
    
    private Integer commentId;
    private String name;
    private String email;
    private String comment;
    private LocalDate datePosted;
}
