package model;

public class Chef extends Staff {
    private String specialization;

    public Chef(String name, String id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
