package ORM;

import javax.persistence.*;

@Entity
@Table(name = "GOODS")
public class Good {
    @Id
    @GeneratedValue(generator = "good_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "good_seq",sequenceName = "good_seq",initialValue = 1,allocationSize = 1)
    private int id;
    private String good;
    private int quantity;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

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

    public Good(String good, int quantity, double price) {
        this.good = good;
        this.quantity = quantity;
        this.price = price;
    }
}
