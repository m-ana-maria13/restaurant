package model;

public class OrderAssignment {

    private static int counter=1;
    private String id;
    private String orderId;
    private String staffId;

    public OrderAssignment( String orderId, String staffId) {
        this.id = String.valueOf(counter);
        counter++;
        this.orderId = orderId;
        this.staffId = staffId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
