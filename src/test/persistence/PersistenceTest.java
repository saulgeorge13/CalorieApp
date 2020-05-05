package persistence;

import exceptions.IllegalLengthException;
import exceptions.IllegalValueException;
import model.Meal;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PersistenceTest {
    Meal testMeal;
    User testUser;

    @BeforeEach
    void runBefore() throws IllegalValueException, IllegalLengthException {
        testMeal = new Meal("TestMeal", 1000);
        testUser = new User("bob", 3000, testMeal);
    }

    @Test
    void testPersistence() {
        Writer.write(testUser);
        try {
            User readUser = Reader.read();
            assertEquals("bob", readUser.getName());
            assertEquals(3000, readUser.getMaxcal());
            Meal readMeal = readUser.getFavemeal();
            assertEquals("TestMeal", readMeal.getName());
            assertEquals(1000, readMeal.getCalories());
        } catch (FileNotFoundException e) {
            fail("Exception should not have been thrown");
        }
    }
}
