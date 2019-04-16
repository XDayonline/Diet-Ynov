package com.leogigant.dietynov;

public class Weight {
    private String date;
    private float value;

    public Weight(String date, float value) {
        this.date = date;
        this.value = value;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public float getValue() {
        return value;
    }
}
