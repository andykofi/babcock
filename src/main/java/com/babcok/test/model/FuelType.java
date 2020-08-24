package com.babcok.test.model;

public enum FuelType {

    Petrol("Petrol"),
    Diesel("Diesel");

    private String value;

    private FuelType( String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
