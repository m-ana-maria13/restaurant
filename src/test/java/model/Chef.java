package model;

public class Chef extends Staff {
    String specialization;

    public Chef(String name, String id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }
}
