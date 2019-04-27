package com.leogigant.dietynov;

public class RecipeSteps {
    private int order;
    private String step;

    public RecipeSteps(int order, String step) {
        this.order = order;
        this.step = step;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
}
