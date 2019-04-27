package com.leogigant.dietynov;

import java.util.ArrayList;

public class Recipe {
    private String title;
    private int portions;
    private String pictureUrl;
    private int timeTotal;
    private int timePrep;
    private int timeBaking;
    private ArrayList<RecipeIngredients> ingredientsList;
    private ArrayList<RecipeSteps> stepsList;
    private float kcal;
    private float protein;
    private float fat;
    private float carbohydrate;
    private float sugar;
    private float satFat;
    private float fiber;
    private float sodium;

    public Recipe(String title, int portions, String pictureUrl, int timeTotal, int timePrep, int timeBaking,
                  ArrayList<RecipeIngredients> ingredientsList, ArrayList<RecipeSteps> stepsList, float kcal,
                  float protein, float fat, float carbohydrate, float sugar, float satFat, float fiber, float sodium) {
        this.title = title;
        this.portions = portions;
        this.pictureUrl = pictureUrl;
        this.timeTotal = timeTotal;
        this.timePrep = timePrep;
        this.timeBaking = timeBaking;
        this.ingredientsList = ingredientsList;
        this.stepsList = stepsList;
        this.kcal = kcal;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.sugar = sugar;
        this.satFat = satFat;
        this.fiber = fiber;
        this.sodium = sodium;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getTimeTotal() {
        return timeTotal;
    }

    public void setTimeTotal(int timeTotal) {
        this.timeTotal = timeTotal;
    }

    public int getTimePrep() {
        return timePrep;
    }

    public void setTimePrep(int timePrep) {
        this.timePrep = timePrep;
    }

    public int getTimeBaking() {
        return timeBaking;
    }

    public void setTimeBaking(int timeBaking) {
        this.timeBaking = timeBaking;
    }

    public ArrayList<RecipeIngredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(ArrayList<RecipeIngredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public ArrayList<RecipeSteps> getStepsList() {
        return stepsList;
    }

    public void setStepsList(ArrayList<RecipeSteps> stepsList) {
        this.stepsList = stepsList;
    }

    public float getKcal() {
        return kcal;
    }

    public void setKcal(float kcal) {
        this.kcal = kcal;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(float carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public float getSugar() {
        return sugar;
    }

    public void setSugar(float sugar) {
        this.sugar = sugar;
    }

    public float getSatFat() {
        return satFat;
    }

    public void setSatFat(float satFat) {
        this.satFat = satFat;
    }

    public float getFiber() {
        return fiber;
    }

    public void setFiber(float fiber) {
        this.fiber = fiber;
    }

    public float getSodium() {
        return sodium;
    }

    public void setSodium(float sodium) {
        this.sodium = sodium;
    }
}
