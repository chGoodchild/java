package shapes;

/**
 * Created by Chandran Goodchild on 22.06.17.
 *
 * A class that describes the characteristics of a rectangle.
 */
public class Rectangle implements Shape {
    public V2 upperLeftCorner;
    public V2 dimensions;

    /**
     * A Rectangle is defined by its upper left corner and its dimensions.
     * Dimensions have to be positive.
     *
     * As we are in cartesian coordinates, a box with upper left corner (0,0)
     * and dimensions (1,1) has a lower right corner of (-1, -1).
     */
    public Rectangle (V2 upperLeftCorner, V2 dimensions) {
        if (dimensions.getY() < 0 || dimensions.getY() < 0) {
            throw new IllegalArgumentException("Bad dimensions: " + dimensions);
        }
        this.upperLeftCorner = upperLeftCorner;
        this.dimensions = dimensions;
    }

    /**
     * Return the upper left the upper left corner
     * @return A two dimensional Vector of type V2.
     */
    public V2 getUpperLeftCorner() {
        return upperLeftCorner;
    }

    /**
     * Return dimensions of the Rectangle.
     * @return A two dimensional Vector of type V2.
     */
    public V2 getDimensions() {
        return dimensions;
    }

    /**
     * Checks whether a point is inside this shape.
     * @param point
     * @return true iff point is inside.
     */
    public boolean contains(V2 point) {
        V2 lowerRight = this.upperLeftCorner.move(new V2(dimensions.getX(), -dimensions.getY()));

        if (upperLeftCorner.getX() <= point.getX() && lowerRight.getX() >= point.getX()
                && upperLeftCorner.getY() >= point.getY() && lowerRight.getY() <= point.getY()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Construct a new shape with the same features as this shape, but moved according to the displacement.
     * @param displacement
     * @return the new displaced shape
     */
    public Rectangle move(V2 displacement) {
        return new Rectangle(this.upperLeftCorner.move(displacement), this.dimensions);
    }

    /**
     * Construct the smallest box such that this shape fits fully inside the box.
     * @return a box such that this shape is inside.
     */
    public Box boundingBox() {
        return new Box(upperLeftCorner, dimensions);
    }


    /**
     * List the contents of this Object.
     * @return Return a string.
     */
    @Override
    public String toString() {
        return "Upper Left: " + upperLeftCorner.toString() +
                "\nDimensions: " + dimensions.toString();
    }

    /**
     * Return the first point of this Object.
     * @return Return a two dimensional Vector.
     */
    public V2 pointOne() {
        return upperLeftCorner;
    }

    /**
     * Return the upper left corner of this Object.
     * @return Return a two dimensional Vector.
     */
    public V2 pointTwo() {
        return dimensions;
    }
}