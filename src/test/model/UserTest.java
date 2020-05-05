package model;

import exceptions.IllegalLengthException;
import exceptions.IllegalValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    User testuser;
    Meal chkburrito;
    Meal tofucurry;

    @BeforeEach
    void runBefore() throws IllegalValueException, IllegalLengthException {
        chkburrito = new Meal("Chicken Burrito", 1080);
        tofucurry = new Meal("Hanoi Tofu Curry", 800);
        testuser = new User("Bob", 2000, chkburrito);
    }

    @Test
    void testConstructor() {
        assertEquals("Bob", testuser.getName());
        assertEquals(2000, testuser.getMaxcal());
        ArrayList<Meal> listofmeals = testuser.getListofmeals();
        assertEquals(0, listofmeals.size());
    }

    @Test
    void testAddSingleMeal() {
        testuser.addMeal(chkburrito);
        assertEquals(1080, testuser.getCalories());
        ArrayList<Meal> listofmeals = testuser.getListofmeals();
        assertEquals(1, listofmeals.size());
    }

    @Test
    void testAddMultipleMeals() {
        testuser.addMeal(chkburrito);
        testuser.addMeal(tofucurry);
        assertEquals(1880, testuser.getCalories());
        ArrayList<Meal> listofmeals = testuser.getListofmeals();
        assertEquals(2, listofmeals.size());
    }

    @Test
    void testAddFaveMeal() {
        testuser.addFaveMeal();
        assertEquals(1080, testuser.getCalories());
        ArrayList<Meal> listofmeals = testuser.getListofmeals();
        assertEquals(1, listofmeals.size());
    }

    @Test
    void testChangeMaxCal() {
        assertEquals(2000, testuser.getMaxcal());
        testuser.setMaxcal(1500);
        assertEquals(1500, testuser.getMaxcal());
    }

    @Test
    void testFaveMeal() {
        assertEquals(chkburrito, testuser.getFavemeal());
        testuser.setFavemeal(tofucurry);
        assertEquals(tofucurry, testuser.getFavemeal());
    }

}

