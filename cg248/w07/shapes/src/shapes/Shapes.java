package shapes;

import java.util.List;

/**
 * Created by Chandran Goodchild on 22.06.17.
 *
 * Create objects of the Interface/type shape..
 */
public class Shapes {
    public static Shape makeEllipse(V2 center, V2 radii) {
        return new Ellipse(center, radii);
    }

    public static Shape makeRectangle(V2 upperLeftCorner, V2 dimensions) {
        return new Rectangle(upperLeftCorner, dimensions);
    }
    public static Shape makePicture(List<Shape> shapes) {
        return new Picture(shapes);
    }
}