package app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
    @NamedQuery(name = "Role.findDefaultRole", query = "SELECT r FROM Role r WHERE r.isDefault = :isDefault")
})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "role_id")
    private String roleId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "is_default")
    private int isDefault;
}
