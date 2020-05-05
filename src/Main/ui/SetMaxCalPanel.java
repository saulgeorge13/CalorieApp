package ui;

import javax.swing.*;
import java.awt.*;

////creates a panel to collect data required change the calorie limit
public class SetMaxCalPanel extends JPanel {

    //MODIFIES: CalorieApp.user
    //EFFECTS: creates the panel to get the new calorie limit and assigns this to the users maxCal value
    public SetMaxCalPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        setLayout(new GridLayout(10, 20));
        setBorder(BorderFactory.createTitledBorder("Personal Details"));
        final JTextField caloriesField = new JTextField(10);
        JButton addBtn = new JButton("Add");
        add(new JLabel("New Max Calories: "));
        add(caloriesField);
        add(addBtn);
        addBtn.addActionListener(e -> {
            int calories1 = Integer.parseInt(caloriesField.getText());
            CalorieApp.user.setMaxcal(calories1);
            CalorieApp.frame4.dispose();
        });
    }
}
