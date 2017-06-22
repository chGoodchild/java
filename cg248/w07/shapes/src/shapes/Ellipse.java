package shapes;

/**
 * Created by Chandran Goodchild on 22.06.17.
 */
public class Ellipse implements Shape {
    public V2 center;
    public V2 radii;

    /**
     * A box is defined by its upper left corner and its dimensions.
     * Dimensions have to be positive.
     *
     * As we are in cartesian coordinates, a box with upper left corner (0,0)
     * and dimensions (1,1) has a lower right corner of (-1, -1).
     */
    public Ellipse (V2 center, V2 radii) {
        if (radii.getY() < 0 || radii.getY() < 0) {
            throw new IllegalArgumentException("Bad dimensions: " + radii);
        }
        this.center = center;
        this.radii = radii;
    }

    public V2 getUpperLeftCorner() {
        return center;
    }

    public V2 getDimensions() {
        return radii;
    }

    /**
     * Checks whether a point is inside this shape.
     * The circumference of an ellipse is given by (a * cos(t) + b * sin(t))
     * https://de.wikipedia.org/wiki/Ellipse#Parameterdarstellungen
     *
     * @param point
     * @return true iff point is inside.
     */
    public boolean contains(V2 point) {

        System.out.println(point.toString());
        System.out.println(center.toString());

        if (center.getX() <= point.getX() && center.getY() < point.getY()) {
            // First Quadrant
            // The point must be smaller than the moving point on the X and on the Y axis.
            System.out.println("1");

            for (double x = 0; x < 1.0 / 4.0; x += 0.00001) {
                if (!(point.getX() > radii.getX() * Math.cos(Math.PI * x) + center.getX()) && !(point.getY() > radii.getY() * Math.sin(Math.PI * x) + center.getY())) {
//                    System.out.println("(" + (radii.getX() * Math.cos(Math.PI * x) + center.getX()) + ", " + (radii.getY() * Math.sin(Math.PI * x) + center.getY()) + ")");

                    return true;
                }
            }
        }

        if (center.getX() > point.getX() && center.getY() <= point.getY()) {
            // Second Quadrant
            // The point must be smaller than the moving point on the Y axis and greater on the X axis.
            System.out.println("2");

            for (double x = 1.0 / 4.0; x < 2.0 / 4.0; x += 0.00001) {
                if (!(point.getX() < -radii.getX() * Math.cos(Math.PI * x) + center.getX()) && !(point.getY() > radii.getY() * Math.sin(Math.PI * x) + center.getY())) {
//                    System.out.println("(" + (-radii.getX() * Math.cos(Math.PI * x) + center.getX()) + ", " + (radii.getY() * Math.sin(Math.PI * x) + center.getY()) + ")");
                    return true;
                }
            }
        }

        if (center.getX() >= point.getX() && center.getY() > point.getY()) {
            // Third Quadrant
            // The point must be greater than the moving point on the Y axis and greater on the X axis.
            System.out.println("3");

            for (double x = 2.0 / 4.0; x < 3.0 / 4.0; x += 0.00001) {
                System.out.println("(" + (-radii.getX() * Math.cos(Math.PI * x) + center.getX()) + ", " + (-radii.getY() * Math.sin(Math.PI * x) + center.getY()) + ")");

                if (!(point.getX() < radii.getX() * Math.cos(Math.PI * x) + center.getX()) && !(point.getY() < -radii.getY() * Math.sin(Math.PI * x) + center.getY())) {
//                    System.out.println("(" + (radii.getX() * Math.cos(Math.PI * x) + center.getX()) + ", " + (-radii.getY() * Math.sin(Math.PI * x) + center.getY()) + ")");
                    return true;
                }
            }
        }

        if (center.getX() < point.getX() && center.getY() >= point.getY()) {
            // Fourth Quadrant
            // The point must be greater than the moving point on the Y axis and smaller on the X axis.
            System.out.println("4");

            for (double x = 3.0 / 4.0; x < 4.0 / 4.0; x += 0.00001) {
                if (!(point.getX() > -radii.getX() * Math.cos(Math.PI * x) + center.getX()) && !(point.getY() < -radii.getY() * Math.sin(Math.PI * x) + center.getY())) {
//                    System.out.println("(" + (-radii.getX() * Math.cos(Math.PI * x) + center.getX()) + ", " + (-radii.getY() * Math.sin(Math.PI * x) + center.getY()) + ")");
                    return true;
                }
            }

            return false;
        }


        V2 lowerRight = this.center.move(radii);
        if (center.getX() < point.getX() && lowerRight.getX() > point.getX()
                && center.getY() > point.getY() && lowerRight.getY() < point.getY()) {
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
    public Ellipse move(V2 displacement) {
        return new Ellipse(this.center.move(new V2(displacement.getX(), -displacement.getY())), this.radii);
    }

    /**
     * Construct the smallest box such that this shape fits fully inside the box.
     * @return a box such that this shape is inside.
     */
    public Box boundingBox() {
        return new Box(center, radii);
    }
}
