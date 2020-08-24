package com.babcok.test.model;

public enum Category {
    Small("Small"),
    Estate("Estate"),
    Van("Van");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
