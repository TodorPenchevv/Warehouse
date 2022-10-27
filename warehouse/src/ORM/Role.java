package ORM;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    @GeneratedValue(generator = "role_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "role_seq",sequenceName = "role_seq",initialValue = 1,allocationSize = 1)
    private int id;
    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany
    @JoinColumn(name = "role_id")
    private List<User> users = new ArrayList<User>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Role(Roles role) {
        this.role = role;
    }

    public Role() {
    }
}
