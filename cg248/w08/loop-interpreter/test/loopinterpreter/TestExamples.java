package loopinterpreter;

import org.junit.Test;

import static loopinterpreter.Expressions.*;
import static loopinterpreter.Statements.*;
import static org.junit.Assert.*;

public class TestExamples {
    /**
     * y := x + 1
     */
    @Test
    public void assignTest() throws Exception {

        State state = new State();
        state.put("X", 42);
        Statement stmt = assign("Y", binop(var("X"), Binary.ADD, constant(1)));
        stmt.run(state);
        assertEquals(Integer.valueOf(42), state.get("X"));
        assertEquals(Integer.valueOf(43), state.get("Y"));

    }

    /**
     * y := x + 1;
     * x := y;
     */
    @Test
    public void seqTest() throws Exception {
        State state = new State();
        state.put("X", 42);
        Statement stmt = seq(assign("Y", binop(var("X"), Binary.ADD, constant(1))),
                             assign("X", var("Y")));
        stmt.run(state);
        assertEquals(Integer.valueOf(43), state.get("X"));
        assertEquals(Integer.valueOf(43), state.get("Y"));
    }

    /**
     * cond(x) {
     *     x := x + 1
     * } else {
     *     x : = x
     * }
     */
    @Test
    public void condTest() throws Exception {
        State state = new State();
        state.put("X", 42);
        Statement stmt = cond(var("X"),
                              assign("X", binop(var("X"), Binary.ADD, constant(1))),
                              assign("X", var("X")));

        stmt.run(state);
        assertEquals(Integer.valueOf(43), state.get("X"));

        state = new State();
        state.put("X", 42);
        assertEquals(0, binop(var("X"), Binary.SUB, var("X")).eval(state));
        stmt = cond(binop(var("X"), Binary.SUB, var("X")),
                    assign("X", binop(var("X"), Binary.ADD, constant(1))),
                    assign("X", var("X")));
        stmt.run(state);
        assertEquals(Integer.valueOf(42), state.get("X"));

    }

    /**
     *
     * loop(x) {
     *    x := x-1
     *    y := y+2
     * }
     */
    @Test
    public void loopTest() throws Exception {
        State state = new State();
        state.put("X", 42);
        state.put("Y", 0);
        Statement stmt = loop(var("X"),
                              seq(assign("X", binop(var("X"), Binary.SUB, constant(1))),
                                  assign("Y", binop(var("Y"), Binary.ADD, constant(2))))
        );
        stmt.run(state);
        assertEquals(state.get("X"), Integer.valueOf(0));
        assertEquals(state.get("Y"), Integer.valueOf(84));
    }

}