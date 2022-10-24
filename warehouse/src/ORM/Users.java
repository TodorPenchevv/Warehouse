package ORM;

import javax.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(generator = "user_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_seq",sequenceName = "user_seq",initialValue = 1,allocationSize = 1)
    private int id;
    private String name;

    public Users(String name) {
        this.name = name;
    }
}
