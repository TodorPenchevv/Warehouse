package ORM;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "INVOICES")
public class Invoice {
    @Id
    @GeneratedValue(generator = "invoice_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "invoice_seq",sequenceName = "invoice_seq",initialValue = 1,allocationSize = 1)
    private int id;
    @Column(name = "in_date")
    @Temporal(TemporalType.DATE)
    private Calendar calendar;

    @OneToMany
    @JoinColumn(name = "invoice_id")
    private List<Invoice_Good> invoice_goods = new ArrayList<Invoice_Good>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public List<Invoice_Good> getInvoice_goods() {
        return invoice_goods;
    }

    public void setInvoice_goods(List<Invoice_Good> invoice_goods) {
        this.invoice_goods = invoice_goods;
    }

    public Invoice(Calendar calendar) {
        this.calendar = calendar;
    }
}
