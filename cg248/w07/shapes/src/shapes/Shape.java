package shapes;

/**
 * Created by thiemann on 11.06.17.
 */
public interface Shape {
    /**
     * Checks whether a point is inside this shape.
     * @param point
     * @return true iff point is inside.
     */
    public boolean contains(V2 point);

    /**
     * Construct a new shape with the same features as this shape, but moved according to the displacement.
     * @param displacement
     * @return the new displaced shape
     */
    public Shape move(V2 displacement);

    /**
     * Construct the smallest box such that this shape fits fully inside the box.
     * @return a box such that this shape is inside.
     */
    public Box boundingBox();
}
