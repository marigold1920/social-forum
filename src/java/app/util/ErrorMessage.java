package app.util;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage implements Serializable {
    private String mailExisted;
    private String passwordNotMatch;
    
    public boolean hasError() {
        
        return mailExisted != null || passwordNotMatch != null;
    }
}
