package shapes;

import java.util.List;

/**
 * Created by Chandran Goodchild on 22.06.17.
 */
public class Shapes {
    public static Shape makeEllipse(V2 center, V2 radii) {
        return new Ellipse(center, radii);
    }

    public static Shape makeRectangle(V2 upperLeftCorner, V2 dimensions) {
        return new Rectangle(upperLeftCorner, dimensions);
    }
    public static Shape makePicture(List<Shape> shapes) {
        return new Rectangle(new V2(1, 1), new V2(1, 1));
    }
}