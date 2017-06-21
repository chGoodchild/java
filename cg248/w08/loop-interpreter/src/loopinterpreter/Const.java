package loopinterpreter;

/**
 * Constant expressions.
 *
 * Created by thiemann on 18.06.17.
 */
public class Const implements Expression {
    private final int value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public int eval(State state) {
        return value;
    }
}
