package ORM;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTS")
public class Client {
    @Id
    @GeneratedValue(generator = "client_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "client_seq",sequenceName = "client_seq",initialValue = 1,allocationSize = 1)
    private int id;
}
