package app.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Comment implements Serializable {
    
    private Integer interactionId;
    private String name;
    private String email;
    private String comment;
    private boolean isLike;
    private boolean isDislike;
}
