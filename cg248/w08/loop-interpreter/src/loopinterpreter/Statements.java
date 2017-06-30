package loopinterpreter;

/**
 * Created by Chandran Goodchild on 29.06.17.
 */
public interface Statements {

    public static Statement assign(String name, Expression exp) {

        return new Statement();
    }
    public static Statement seq(Statement s1, Statement s2) {

        return new Statement();
    }

    public static Statement cond(Expression exp, Statement s1, Statement s2) {

        return new Statement();
    }

    public static Statement loop(Expression exp, Statement s) {

        return new Statement();
    }

}
