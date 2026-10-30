package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String name;
    private List<Order> orders;
    private double discount;


    public Customer(String id, String name, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.orders = orders;
        this.discount=0.0;

    }


    public Customer(String id, String name, List<Order> orders, double discount) {
        this.id = id;
        this.name = name;
        this.orders = orders;
        this.discount=discount;

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
