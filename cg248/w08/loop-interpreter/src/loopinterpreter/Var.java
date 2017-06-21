package loopinterpreter;

/**
 * Variable expressions. There value is determined by the state. The behavior is
 * undefined if a variable does not yet exist in the state.
 * <p>
 * Created by thiemann on 18.06.17.
 */
public class Var implements Expression {
    private final String name;

    public Var(String name) {
        this.name = name;
    }

    @Override
    public int eval(State state) {
        return state.get(name);
    }
}
