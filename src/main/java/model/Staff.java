package model;

public abstract class Staff {
    private String id;
    private String name;
    private String status; // neue Eigenschaft

    public Staff(String name, String id) {
        this.name = name;
        this.id = id;
        this.status="free";
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
