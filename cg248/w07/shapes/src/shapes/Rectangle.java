package shapes;

/**
 * Created by Chandran Goodchild on 22.06.17.
 */
public class Rectangle implements Shape {
    public V2 upperLeftCorner;
    public V2 dimensions;

    /**
     * A box is defined by its upper left corner and its dimensions.
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

    public V2 getUpperLeftCorner() {
        return upperLeftCorner;
    }

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

        System.out.println(toString());
        System.out.println("Lower Right: " + lowerRight.toString());
        System.out.println("Point: " + point.toString());

        if (upperLeftCorner.getX() < point.getX() && lowerRight.getX() > point.getX()
                && upperLeftCorner.getY() > point.getY() && lowerRight.getY() < point.getY()) {
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


    @Override
    public String toString() {
        return "Upper Left: " + upperLeftCorner.toString() +
                "\nDimensions: " + dimensions.toString();
    }
}