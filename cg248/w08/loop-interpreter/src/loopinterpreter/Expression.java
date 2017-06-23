package loopinterpreter;

import loopinterpreter.State;

/**
 * An interface for arithmetic expressions with variables. The value of
 * variables is determined by a Map from String to int.
 * <p>
 * When arithmetic expressions are interpreted logically, then x == 0 is false
 * and x != 0 is true, for integer x.
 * <p>
 * <p>
 * Created by thiemann on 18.06.17.
 */
public interface Expression {
    public int eval(State state);
}
