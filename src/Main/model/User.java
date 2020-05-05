package model;

import java.util.ArrayList;

//Represents a user with a name, calorie limit, list of meals and favourite meal
public class User {
    private String name;
    private int maxcal;
    private ArrayList<Meal> listofmeals;
    private Meal favemeal;

    //REQUIRES: name is String of non-zero length
    //EFFECTS: name is set to user name, maxcal is set as users calorie limit, an empty array is created to store
    // the users consumed meals, favemeal is set as the users favourite meal.
    public User(String name, int maxcal, Meal favemeal) {
        this.name = name;
        this.maxcal = maxcal;
        listofmeals = new ArrayList<>();
        this.favemeal = favemeal;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Meal> getListofmeals() {
        return listofmeals;
    }

    //MODIFIES: this
    //EFFECTS: meal is added to the listofmeals
    public void addMeal(Meal meal) {
        listofmeals.add(meal);
    }

    //MODIFIES: this
    //EFFECTS: favemeal is added to the listofmeals
    public void addFaveMeal() {
        listofmeals.add(this.favemeal);
    }


    public int getMaxcal() {
        return maxcal;
    }

    public void setMaxcal(int maxcal) {
        this.maxcal = maxcal;
    }


    public Meal getFavemeal() {
        return this.favemeal;
    }

    public void setFavemeal(Meal favemeal) {
        this.favemeal = favemeal;
    }

    //EFFECTS: returns the calories consumed by the user
    public int getCalories() {
        int index = 0;
        int calories = 0;
        while (index < listofmeals.size()) {
            Meal thismeal = listofmeals.get(index);
            calories = calories + thismeal.getCalories();
            index++;
        }
        return calories;
    }

}
