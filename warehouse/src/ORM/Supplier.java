package ORM;

import javax.persistence.*;

@Entity
@Table(name = "SUPPLIERS")
public class Supplier {
    @Id
    @GeneratedValue(generator = "supplier_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "supplier_seq",sequenceName = "supplier_seq",initialValue = 1,allocationSize = 1)
    private int id;
}
