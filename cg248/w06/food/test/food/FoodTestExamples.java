package food;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Some test cases.
 */
public class FoodTestExamples {
    /**
     * Add different types of food to the meal in various quantities. Then check if the returned calorific value is
     * correct.
     */
    @Test
    public void testMeal() {
        Map<Food, Double> ingredients = new HashMap<>();
        ingredients.put(new Food("Water", 0.0, 0.0, 0.0), 1000.0);
        ingredients.put(new Food("Sugar", 1.0, 0.0, 0.0), 100.0);
        ingredients.put(new Food("Protein", 0.0, 0.0, 1.0), 100.0);

        Meal shake = new Meal("Fitness-Shake", ingredients);
        assertEquals(3400.0, shake.getCalorificValue(), 0.0001);
    }

    /**
     * Create an instance of Food, which has 100% carbohydrates, 100% fat and 100% protein. Such an instantiation is
     * forbidden, as the nutrients must add up to maximum 100%, thus we expect an IllegalArgumentException.
     * @throws Throwable : IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalFood() throws Throwable{
        new Food("Burger", 1, 1, 1);
    }
}
