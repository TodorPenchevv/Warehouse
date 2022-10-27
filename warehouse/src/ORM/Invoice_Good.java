package ORM;

import javax.persistence.*;

@Entity
@Table(name = "INVOICE_GOOD")
public class Invoice_Good {
    @Id
    @GeneratedValue(generator = "invoice_good_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "invoice_good_seq",sequenceName = "invoice_good_seq",initialValue = 1,allocationSize = 1)
    private int id;
    @Column(name = "good_quantity")
    private int quantity;
    @Column(name = "good_price")
    private double price;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Invoice_Good(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Invoice_Good() {
    }


}
