package ORM;

import javax.persistence.*;

@Entity
public class Roles {
    @Id
    @GeneratedValue(generator = "role_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "role_seq",sequenceName = "role_seq",initialValue = 1,allocationSize = 1)
    private int id;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Roles(String role) {
        this.role = role;
    }
}
