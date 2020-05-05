package ui;

import model.User;
import persistence.Reader;
import persistence.Writer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.*;
import java.io.*;


//Calorie Tracker Application
public class CalorieApp extends JFrame {
    public JPanel panel;
    public static User user;
    public static JFrame frame1 = new JFrame("New User");
    public static JFrame frame2 = new JFrame("Add Meal");
    public static JFrame frame3 = new JFrame("Display Info");
    public static JFrame frame4 = new JFrame("Set Max Calories");
    JButton btn1 = new JButton("New User");
    JButton btn2 = new JButton("Add Meal");
    JButton btn3 = new JButton("Add Fave Meal");
    JButton btn4 = new JButton("Display info");
    JButton btn5 = new JButton("Set Max Calories");
    JButton btn6 = new JButton("Reset Meals");
    JButton btn7 = new JButton("Save and Quit");

    public static void music(String filePath) {
        try {
            InputStream music = new FileInputStream(new File(filePath));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //EFFECTS: starts the GUI by displaying the main menu and loading the user data if it exists in file
    public CalorieApp(String title) {
        super(title);
        try {
            user = Reader.read();
        } catch (FileNotFoundException e) {
            newUser();
        }
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);
        super.add(panel);
        btn1.addActionListener(e -> newUser());
        btn2.addActionListener(e -> addMeal());
        btn3.addActionListener(e -> addFaveMeal());
        btn4.addActionListener(e -> displayInfo());
        btn5.addActionListener(e -> setMaxCal());
        btn6.addActionListener(e -> resetMeals());
        btn7.addActionListener(e -> saveAndQuit());
    }

    //EFFECTS: displays the new frame for a new user
    public static void newUser() {
        frame1.setSize(500, 400);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        NewUserPanel panel1 = new NewUserPanel();
        frame1.add(panel1);
    }

    //EFFECTS: displays the new frame to add meal
    public static void addMeal() {
        frame2.setSize(500, 400);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        AddMealPanel panel1 = new AddMealPanel();
        frame2.add(panel1);
    }

    //MODIFIES: this
    //EFFECTS: add the users favourite meal to the list of consumed meals
    public void addFaveMeal() {
        user.addMeal(user.getFavemeal());
        music("data/sms-alert-3-daniel_simon.wav");
    }

    //EFFECTS: displays the new frame with User info
    public void displayInfo() {
        frame3.setSize(500, 400);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);
        DisplayInfoPanel info = new DisplayInfoPanel();
        frame3.add(info);
    }

    //EFFECTS: displays the new frame to set a new Calorie Limit
    public void setMaxCal() {
        frame4.setSize(500, 400);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(true);
        SetMaxCalPanel max = new SetMaxCalPanel();
        frame4.add(max);
    }

    //MODIFIES: this
    //EFFECTS: resets the consumed meals of the user and then saves the data to file
    public void resetMeals() {
        user = new User(user.getName(), user.getMaxcal(), user.getFavemeal());
        Writer.write(user);
        music("data/sms-alert-3-daniel_simon.wav");
    }

    //EFFECTS: saves the data to file before exiting the application
    public void saveAndQuit() {
        Writer.write(user);
        music("data/sms-alert-3-daniel_simon.wav");
        this.dispose();
    }
}
