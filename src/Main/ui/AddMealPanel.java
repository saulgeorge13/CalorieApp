package ui;

import exceptions.IllegalLengthException;
import exceptions.IllegalValueException;
import model.Meal;

import javax.swing.*;
import java.awt.*;

//creates a panel to collect data required to add a meal
public class AddMealPanel extends JPanel {
    JTextField nameField = new JTextField(10);
    JTextField caloriesField = new JTextField(10);

    //MODIFIES: CalorieApp.user
    //EFFECTS: creates the panel to collect meal info and adds it to users list of consumed meals
    public AddMealPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        setLayout(new GridLayout(10, 20));
        setBorder(BorderFactory.createTitledBorder("Personal Details"));
        JButton addBtn = new JButton("Add");
        add(new JLabel("Meal: "));
        add(nameField);
        add(new JLabel("Calories: "));
        add(caloriesField);
        add(addBtn);
        addBtn.addActionListener(e -> {
            if (caloriesField.getText().length() < 1) {
                resetPanel();
            } else {
                String name1 = nameField.getText();
                int calories1 = Integer.parseInt(caloriesField.getText());
                help(name1, calories1);
            }
        });
    }



    public void help(String name1, int calories1) {
        try {
            Meal meal = new Meal(name1, calories1);
            CalorieApp.user.addMeal(meal);
            CalorieApp.frame2.dispose();
        } catch (IllegalValueException | IllegalLengthException ex) {
            resetPanel();
        }
    }

    private void resetPanel() {
        nameField.setText("");
        caloriesField.setText("");
        CalorieApp.addMeal();
    }
}
