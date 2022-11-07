package GUI;

public class CustomRow {
    private String date;
    private String type;
    private String partner;
    private String user;

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getPartner() {
        return partner;
    }

    public String getUser(){
        return user;
    }


    //Constructor for simple Invoice query
    public CustomRow(String date, String type, String partner, String user) {
        this.date = date;
        this.type = type;
        this.partner = partner;
        this.user = user;
    }
}