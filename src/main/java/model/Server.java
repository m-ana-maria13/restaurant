package model;

public class Server extends Staff {
    private String designation;

    public Server(String name, String id, String designation) {
        super(name, id);
        this.designation=designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
