package model;

public abstract class Staff {
    private static int counter=1;
    private String name;
    private String id;
    private String status; // neue Eigenschaft

    public Staff( String name) {
        this.id = String.valueOf(counter);
        counter++;
        this.name = name;
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
