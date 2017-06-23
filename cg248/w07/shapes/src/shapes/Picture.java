package shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chandran Goodchild on 23.06.17.
 */
public class Picture implements Shape {
    List<Shape> shapes = new ArrayList<Shape>();
    List<V2> picture = new ArrayList<V2>();

    public Picture (List<Shape> shapes) {
        this.shapes = shapes;
        int i = 0;
        while (i < shapes.size()) {
            picture.add(shapes.get(i).pointOne());
            picture.add(shapes.get(i).pointTwo());
            i++;
        }
    }

    public List<V2> returnPicture () {
        return picture;
    }

    /**
     * Construct the smallest box such that this shape fits fully inside the box.
     * @return a box such that this shape is inside.
     */
    public Box boundingBox() {
        double uLx;
        double uLy;
        double dimX;
        double dimY;

//        Shape upper;
//        Shape left;
//
//        Shape lower;
//        Shape right;

        uLx = shapes.get(0).boundingBox().getUpperLeftCorner().getX();
        uLy = shapes.get(0).boundingBox().getUpperLeftCorner().getY();
        dimX = shapes.get(0).boundingBox().getUpperLeftCorner().getX()
                + shapes.get(0).boundingBox().getDimensions().getX();
        dimY = shapes.get(0).boundingBox().getUpperLeftCorner().getY()
                + shapes.get(0).boundingBox().getDimensions().getY();

        for(int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).boundingBox().getUpperLeftCorner().getX() < uLx) {
                uLx = shapes.get(i).boundingBox().getUpperLeftCorner().getX();
            }

            if (shapes.get(i).boundingBox().getUpperLeftCorner().getY() > uLy) {
                uLy = shapes.get(i).boundingBox().getUpperLeftCorner().getY();
            }

            if (shapes.get(i).boundingBox().getUpperLeftCorner().getX()
                    - shapes.get(i).boundingBox().getUpperLeftCorner().getX() > dimX) {
                dimX = shapes.get(i).boundingBox().getDimensions().getX()
                        - shapes.get(i).boundingBox().getUpperLeftCorner().getX();
            }

            if (shapes.get(i).boundingBox().getUpperLeftCorner().getY()
                    - shapes.get(i).boundingBox().getUpperLeftCorner().getY() > dimY) {
                dimY = shapes.get(i).boundingBox().getUpperLeftCorner().getY()
                        - shapes.get(i).boundingBox().getDimensions().getY();
            }

            System.out.println(uLx + ", " + uLy + ", " + dimX + ", " + dimY);
        }

        return new Box(new V2(uLx, uLy), new V2(dimX - uLx, uLy - dimY));
    }


    /**
     * Checks whether a point is inside this shape.
     * @param point
     * @return true iff point is inside.
     */
    public boolean contains(V2 point) {
        for(int i = 0; i < shapes.size(); i++) {
            if(shapes.get(i).contains(point)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Construct a new shape with the same features as this shape, but moved according to the displacement.
     * @param displacement
     * @return the new displaced shape
     */
    public Rectangle move(V2 displacement) {
        return new Rectangle(this.picture.get(0).move(displacement), this.picture.get(0));
    }

    public V2 pointOne() {
        return new V2(1, 1);
    }

    public V2 pointTwo() {
        return new V2(1, 1);
    }
}
