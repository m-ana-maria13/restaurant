package model;

public abstract class Staff {
    public String id;
    public String name;

    public Staff(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
