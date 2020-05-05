package model;

import exceptions.IllegalLengthException;
import exceptions.IllegalValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class MealTest {
    Meal testMeal;
    Meal testMeal1;

    @BeforeEach
    void runBefore() throws IllegalValueException, IllegalLengthException {
        testMeal = new Meal("Chicken Burrito", 1080);
        testMeal1 = new Meal("Hanoi Tofu Curry", 800);
    }

    @Test
    void testConstructorValid() {
        assertEquals("Chicken Burrito", testMeal.getName());
        assertEquals("Hanoi Tofu Curry", testMeal1.getName());
        assertEquals(1080, testMeal.getCalories());
        assertEquals(800, testMeal1.getCalories());
    }

    @Test
    void testInvalidCal() {
        try {
            testMeal = new Meal("Chicken Burrito", 0);
            fail("Exception should be thrown");
        } catch (IllegalValueException e) {
            System.out.println("Exception caught");
        } catch (IllegalLengthException e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    void testInvalidName() {
        try {
            testMeal = new Meal("", 600);
            fail("Exception should be thrown");
        } catch (IllegalValueException e) {
            fail("Exception should not be thrown");
        } catch (IllegalLengthException e) {
            System.out.println("Exception caught");
        }
    }
}
