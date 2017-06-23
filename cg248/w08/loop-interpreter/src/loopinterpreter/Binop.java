package loopinterpreter;

/**
 * Binary operations on variables. The to be performed is determined by the class "Binary"
 *
 * Created by thiemann on 18.06.17.
 */
public class Binop implements Expression {
    private final Expression e1;
    private final Binary op;
    private final Expression e2;

    public Binop(Expression e1, Binary op, Expression e2) {
        this.e1 = e1;
        this.op = op;
        this.e2 = e2;
    }

    @Override
    public int eval(State state) {
        int r1 = e1.eval(state);
        int r2 = e2.eval(state);
        return op.exec(r1, r2);
    }
}
