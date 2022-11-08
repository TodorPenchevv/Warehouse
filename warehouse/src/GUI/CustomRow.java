package GUI;

public class CustomRow {
    private String userName;
    private String partnerName;
    private String role;
    private String good;
    private String date;
    private String transaction;
    private double price;
    private int quantity;
    private int minQuantity;

    public String getUserName() {
        return userName;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public String getRole() {
        return role;
    }

    public String getGood() {
        return good;
    }

    public String getDate() {
        return date;
    }

    public String getTransaction() {
        return transaction;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    private CustomRow(Builder builder){
        this.userName = builder.userName;
        this.partnerName = builder.partnerName;
        this.role = builder.role;
        this.good = builder.good;
        this.date = builder.date;
        this.transaction = builder.transaction;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.minQuantity = builder.minQuantity;
    }


    public static class Builder {
        private String userName;
        private String partnerName;
        private String role;
        private String good;
        private String date;
        private String transaction;
        private double price;
        private int quantity;
        private int minQuantity;

        public Builder withUserName(String userName){
            this.userName = userName;
            return this;
        }

        public Builder withPartnerName(String partnerName){
            this.partnerName = partnerName;
            return this;
        }

        public Builder withRole(String role){
            this.role = role;
            return this;
        }

        public Builder withGood(String good){
            this.good = good;
            return this;
        }

        public Builder withDate(String date){
            this.date = date;
            return this;
        }

        public Builder withTransaction(String transaction){
            this.transaction = transaction;
            return this;
        }

        public Builder withPrice(Double price){
            this.price = price;
            return this;
        }

        public Builder withQuantity(int quantity, int minQuantity){
            this.quantity = quantity;
            this.minQuantity = minQuantity;
            return this;
        }

       public CustomRow build(){
            return new CustomRow(this);
       }
    }
}