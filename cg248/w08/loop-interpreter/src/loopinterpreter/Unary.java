package loopinterpreter;

/**
 * Unary opertions on ints.
 *
 * Created by thiemann on 18.06.17.
 */
public enum Unary {
    NEG, NOT;

    public int exec(int r) {
        switch(this) {
            case NEG: return -r;
            case NOT: return r == 0? 1 : 0;
            default: throw new RuntimeException("Impossible case");
        }
    }
}
