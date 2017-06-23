package food;

import java.util.Map;

/**
 * This class defines a meal, which has a name and ingredients.
 */
public class Meal {

	public String name;
	public Map<Food, Double> ingredients;
	// A "reference type" is
	// required. --> "Double"
	// must be used rather
	// than "double"

	/**
	 * Initialize this instance of Meal.
	 * @param name : String : The name of this Instance.
	 * @param ingredients : Contains the ingredients their
	 * quantities for this meal.
	 */
	public Meal(String name, Map<Food, Double>ingredients) {
		this.name = name;
		this.ingredients = ingredients;
	}

	/**
	 * @return Return the contents of this meal (object) in the
	 * form of a String.
	 */
	public String toString() {
		return this.name + this.ingredients.toString();
	}

	/**
	 * @return Return the name of this meal (object) in the form
	 * of a String.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return Return the ingredients of this meal (object) as a
	 * Map.
	 */
	public Map<Food, Double> getIngredients() {
		return this.ingredients;
	}

	/**
	 * @return Return the calorific value of this meal (object) as
	 * a double.
	 */
	public double getCalorificValue() {
		double calorificValue = 0;

		for (Map.Entry<Food, Double> entry : ingredients.entrySet()) {
			calorificValue += entry.getKey().relativeEnergyDensity() * entry.getValue();
		}

		return calorificValue;
	}
}
