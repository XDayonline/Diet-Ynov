package com.leogigant.dietynov;

public class RecipeIngredients {
    private int quantity;
    private String unity;
    private String name;

    public int getQuantity() {
        return quantity;
    }

    public String getUnity() {
        return unity;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecipeIngredients(int quantity, String unity, String name) {
        this.quantity = quantity;
        this.unity = unity;
        this.name = name;
    }
}
