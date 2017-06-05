package food;

import java.util.Objects;

/**
 * A class that defines the properties of food. Each instance of this
 * class has a name, a carbohydrate share, a fat share and a protein
 * share.
 */
public class Food {

    public String name;
    public double carbohydrateShare;
    public double fatShare;
    public double proteinShare;

    /**
     * The constructor of food. The properties of an instance are
     * initialized in the constructor, as long as the total share of
     * the three nutrients doesn't exceed 1 and none of the nutrients
     * have a negative share.
     * @param name  : String : Name of this instance.
     * @param carbohydrateShare : double : The carbohydrate share.
     * @param fatShare : double : The fat share.
     * @param proteinShare : double : The protein share.
     */
    public Food(String name, double carbohydrateShare, double fatShare, double proteinShare) {

        if ((carbohydrateShare < 0 || fatShare < 0 || proteinShare < 0) || (fatShare + carbohydrateShare + proteinShare > 1)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.carbohydrateShare = carbohydrateShare;
        this.fatShare = fatShare;
        this.proteinShare = proteinShare;
    }

    /**
     * @return Return the contents of this instance as a String.
     */
    public String toString() {
        return this.name + Double.toString(this.carbohydrateShare) + Double.toString(this.fatShare) + Double.toString(this.proteinShare);
        //return this.name + Double.toString(this.carbohydrateShare * 17) + Double.toString(this.fatShare * 17) + Double.toString(this.proteinShare * 37);
    }

    /**
     * @return Return the name of this instance as a String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return Return the energy density of this instance as a double.
     */
    public double relativeEnergyDensity() {
        return (17 * carbohydrateShare) + (17 * proteinShare) + (37 * fatShare);
    }

    /**
     * @return Return a custom hash code.
     */
    @Override public int hashCode() {
        return Objects.hash(name, carbohydrateShare, fatShare, proteinShare);
    }

    // @Override public boolean equals(Food r) {
    // Error:(70, 5) java: method does not override or implement a method from a supertype

    /**
     * @param r : An instance of this class.
     * @return Return true if the instance in the argument of the
     * function has the same contents as this instance.
     */
    public boolean equals(Food r) {
        return (r.name.equals(this.name) &&
                (r.carbohydrateShare == this.carbohydrateShare) &&
                (r.fatShare == this.fatShare) &&
                (r.proteinShare == this.proteinShare));
    }
}
