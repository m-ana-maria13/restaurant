package model;

public class Server extends Staff {
    public String designation;

    public Server(String name, String id, String designation) {
        super(name, id);
        this.designation=designation;
    }
}
