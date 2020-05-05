package persistence;

import com.google.gson.Gson;
import model.User;
import java.io.FileNotFoundException;
import java.io.FileReader;

//A reader that can read user data from a file
public class Reader {
    public static final String USER_FILE = "./data/user.json";

    //EFFECTS: returns user data stored on the file as a User object
    public static User read() throws FileNotFoundException {
        Gson gson = new Gson();
        User user;
        FileReader reader = new FileReader("./data/user.json");
        user = gson.fromJson(reader, User.class);
        return user;
    }
}
