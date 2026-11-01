package com.example.restaurant_management_app.model;

public class Chef extends Staff {
    private String specialization;

    public Chef( String name, String specialization) {
        super(name);
        this.specialization = specialization;
    }

    public Chef() {}

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
