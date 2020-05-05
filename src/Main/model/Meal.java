package model;

import exceptions.IllegalLengthException;
import exceptions.IllegalValueException;

//Represents a Meal with a name and its calories
public class Meal {
    private String name;
    private int calories;

    //REQUIRES: name is string of non-zero length, calories is int > 0
    //EFFECTS: name is set to meal name and calories is set to meal calories
    public Meal(String name, int calories) throws IllegalValueException, IllegalLengthException {
        if (calories < 1) {
            throw new IllegalValueException("Must be > 0");
        } else if (name.length() < 1) {
            throw new IllegalLengthException("Must have min 1 char");
        } else {
            this.name = name;
            this.calories = calories;
        }
    }

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }
}
