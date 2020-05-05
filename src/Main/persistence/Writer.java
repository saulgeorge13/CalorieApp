package persistence;

import com.google.gson.Gson;
import model.User;

import java.io.*;

//A writer that can write user data to a file
public class Writer {
    public static final String USER_FILE = "./data/user.json";

    //EFFECTS: writes the user data to the file
    public static void write(User user) {
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(new File(USER_FILE));
            gson.toJson(user, writer);
            writer.close();
            System.out.println("User saved to file " + USER_FILE);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to save file " + USER_FILE);
        }
    }


}
