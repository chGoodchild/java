package loopinterpreter;

/**
 * Binary operations on integers.
 *
 * Created by thiemann on 18.06.17.
 */
public enum Binary {
    ADD, SUB, MUL, DIV, EQUAL, LESSTHAN;

    public int exec(int r1, int r2) {
        switch(this) {
            case ADD:
                return r1 + r2;
            case SUB:
                return r1 - r2;
            case MUL:
                return r1 * r2;
            case DIV:
                return r1 / r2;
            case EQUAL:
                return r1 == r2 ? 1 : 0;
            case LESSTHAN:
                return r1 < r2 ? 1 : 0;
            default: throw new RuntimeException("Impossible case");
        }
    }
}
