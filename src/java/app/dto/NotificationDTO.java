package app.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO implements Serializable {
    
    private Integer notificationId;
    private String content;
    private LocalDate createdDate;
    private String owner;
    private Integer articleId;
}
