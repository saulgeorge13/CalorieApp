package ui;

import exceptions.IllegalLengthException;
import exceptions.IllegalValueException;
import model.Meal;
import model.User;

import javax.swing.*;
import java.awt.*;

////creates a panel to collect new user data
public class NewUserPanel extends JPanel {
    JTextField nameField = new JTextField(10);
    JTextField maxCalField = new JTextField(10);
    JTextField faveFoodField = new JTextField(10);
    JTextField faveFoodCalField = new JTextField(10);

    //MODIFIES: CalorieApp.user
    //EFFECTS:
    public NewUserPanel() {
        setBorder(BorderFactory.createTitledBorder("New User"));
        setLayout(new GridLayout(10, 20));
        add(new JLabel("Name: "));
        add(nameField);
        add(new JLabel("Max Calories: "));
        add(maxCalField);
        add(new JLabel("Fave Food: "));
        add(faveFoodField);
        add(new JLabel("Fave Food Calories: "));
        add(faveFoodCalField);
        JButton addBtn = new JButton("Add");
        add(addBtn);
        addBtn.addActionListener(e -> {
            if (maxCalField.getText().length() < 1 || faveFoodCalField.getText().length() < 1) {
                resetPanel();
            } else {
                helpNewUser(nameField.getText(), Integer.parseInt(maxCalField.getText()), faveFoodField.getText(),
                        Integer.parseInt(faveFoodCalField.getText()));
            }

        });
    }

    private void helpNewUser(String name, int maxCal, String faveFood, int faveFoodCal) {
        Meal faveMeal;
        try {
            faveMeal = new Meal(faveFood, faveFoodCal);
            CalorieApp.user = new User(name, maxCal, faveMeal);
            CalorieApp.frame1.dispose();
        } catch (IllegalValueException | IllegalLengthException e) {
            resetPanel();
        }
    }

    private void resetPanel() {
        nameField.setText("");
        maxCalField.setText("");
        faveFoodField.setText("");
        faveFoodCalField.setText("");
        CalorieApp.newUser();
    }
}
