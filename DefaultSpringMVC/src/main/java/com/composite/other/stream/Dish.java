package com.composite.other.stream;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String name;

    private String type;

    private boolean vegetarian;

    private int calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public static List<Dish> getDishList() {
        List<Dish> dishList = new ArrayList<>();
        return dishList;
    }
}
