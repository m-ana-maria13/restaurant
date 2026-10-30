package model;

import java.util.List;

public class Table {
    private String id;
    private int number;
    private List<Order> orders;
    private String occupiedStatus;

    public Table(String id, int number, List<Order> orders, String occupiedStatus) {
        this.id = id;
        this.number = number;
        this.orders = orders;
        this.occupiedStatus = occupiedStatus;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getOccupiedStatus() {
        return occupiedStatus;
    }

    public void setOccupiedStatus(String occupiedStatus) {
        this.occupiedStatus = occupiedStatus;
    }
}
