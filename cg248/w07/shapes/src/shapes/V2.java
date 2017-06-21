package shapes;

/**
 * A two dimensional vector.
 * Created by thiemann on 11.06.17.
 */
public class V2 {
    private final double x;
    private final double y;

    public V2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public V2 move(V2 displacement) {
        return new V2(
                x + displacement.getX(),
                y + displacement.getY());
    }

    @Override
    public String toString() {
        return "V2{" +
               "x=" + x +
               ", y=" + y +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        V2 v2 = (V2) o;

        if (Double.compare(v2.x, x) != 0) return false;
        return Double.compare(v2.y, y) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
