package loopinterpreter;

/**
 * Unary operations as expressions. The result is determined by Unary.
 *
 * Created by thiemann on 18.06.17.
 */
public class Unop implements Expression {
    private final Unary op;
    private final Expression exp;

    public Unop(Unary op, Expression e) {
        this.op = op;
        this.exp = e;
    }

    @Override
    public int eval(State state) {
        int r = exp.eval(state);
        return op.exec(r);
    }
}
