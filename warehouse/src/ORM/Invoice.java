package ORM;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "INVOICES")
public class Invoice {
    @Id
    @GeneratedValue(generator = "invoice_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "invoice_seq",sequenceName = "invoice_seq",initialValue = 1,allocationSize = 1)
    private int id;
    //private LocalDate date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Invoice(LocalDate date) {
        this.date = date;
    }*/
}
