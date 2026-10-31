package model;

public class MenuItem {

    private static int counter=1;
    private String id;
    private String name;
    private double price;

    public MenuItem( String name, double price) {
        this.id = String.valueOf(counter);
        counter++;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
