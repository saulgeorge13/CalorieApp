package ui;

import model.Meal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//creates a panel to display the users data
public class DisplayInfoPanel extends JPanel {

    //EFFECTS: displays all data saved for a user
    public DisplayInfoPanel() {
        Dimension size = getPreferredSize();
        size.width = 1000;
        setPreferredSize(size);
        JTextArea text = new JTextArea();
        text.append("Name: " + CalorieApp.user.getName());
        text.append("\nCalorie Limit: " + CalorieApp.user.getMaxcal());
        text.append("\nFavourite Meal: " + CalorieApp.user.getFavemeal().getName());
        text.append("\nMeals Consumed: \n");
        int index = 0;
        ArrayList<Meal> listOfMeals = CalorieApp.user.getListofmeals();
        while (index < listOfMeals.size()) {
            text.append("\n" + mealsConsumed(index, listOfMeals));
            index++;
        }
        text.append("\nCalories Consumed: " + CalorieApp.user.getCalories());
        text.append(calorieInfo());
        add(text);
        JButton menuBtn = new JButton("Menu");
        add(menuBtn);
        menuBtn.addActionListener(e -> CalorieApp.frame3.dispose());
    }

    //EFFECTS: returns the meal at given index i
    public String mealsConsumed(int i, ArrayList<Meal> listOfMeals) {
        return listOfMeals.get(i).getName();
    }

    public String calorieInfo() {
        if (CalorieApp.user.getCalories() > CalorieApp.user.getMaxcal()) {
            return ("\nYou've consumed more than your set limit");
        } else {
            return ("\nYou are within your set limit");
        }
    }
}
