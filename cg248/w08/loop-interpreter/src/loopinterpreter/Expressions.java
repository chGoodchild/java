package loopinterpreter;

/**
 * Created by thiemann on 18.06.17.
 */
public class Expressions {
    public static Expression constant(int value) {
        return new Const(value);
    }

    public static Expression unop(Unary op, Expression e) {
        return new Unop(op, e);
    }

    public static Expression binop(Expression e1, Binary op, Expression e2) {
        return new Binop(e1, op, e2);
    }

    public static Expression var(String name) {
        return new Var(name);
    }
}
