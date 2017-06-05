package food;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.*;
/**
 * Created by Chandran Goodchild on 6/5/17.
 */
public class MyTestCases {
    /**
     * Test all the methods in the class Meal.
     */
    @Test
    public void testMeal() {
        Map<Food, Double> ingredients = new HashMap<>();
        ingredients.put(new Food("SoylentGreen", 0.3, 0.3, 0.3), 2000.0);

        Meal nano = new Meal("nanoFood", ingredients);
        assertEquals(3400.0, nano.getCalorificValue(), 0.0001);
        assertEquals("nanoFood", nano.name);
        assertEquals(ingredients, nano.ingredients);
        assertEquals("nanoFood" + ingredients.toString(), nano.toString());
        assertEquals("nanoFood", nano.getName());
        assertEquals(nano.ingredients, nano.getIngredients());
        assertEquals(2000 * (0.3 * 17 + 0.3 * 17 + 37 * 0.3), nano.getCalorificValue(), 0.0001);
    }

    /**
     * Test all the methods in the class Food.
     */
    @Test
    public void testFood() {
        Food soylent = new Food("SoylentGreen", 0.3, 0.3, 0.3);
        Food fakeLent = new Food("FakeLentGreen", 0.3, 0.3, 0.3);

        assertEquals("SoylentGreen", soylent.name);
        assertEquals(0.3, soylent.carbohydrateShare, 0.0001);
        assertEquals(0.3, soylent.fatShare, 0.0001);
        assertEquals(0.3, soylent.proteinShare, 0.0001);
        assertEquals("nanoFood0.30.30.3", soylent.toString(), 0.0001);
        assertEquals("nanoFood", soylent.getName());
        assertEquals(17 * 0.3 + 17 * 0.3 + 37 * 0.3, soylent.relativeEnergyDensity(), 0.0001);
        assertEquals(Objects.hash("SoylentGreen", 0.3, 0.3, 0.4), soylent.hashCode(), 0.0001);
        assertEquals(true, soylent.equals(soylent));
        assertEquals(false, soylent.equals(fakeLent));
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

    /**
     * Create another illegal instance of food and make sure it returns an IllegalArgumentException.
     * @throws Throwable : IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalFoodTwo() throws Throwable{
        new Food("Burger", -1, 0, 0);
    }
}
